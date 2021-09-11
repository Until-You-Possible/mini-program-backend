package com.lin.missyou.core.interceptors;

import com.auth0.jwt.interfaces.Claim;
import com.lin.missyou.exception.Http.ForbiddenException;
import com.lin.missyou.exception.Http.UnAuthenticatedException;
import com.lin.missyou.util.JwtToken;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Optional;

public class PermissionInterceptor implements AsyncHandlerInterceptor {

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        AsyncHandlerInterceptor.super.afterConcurrentHandlingStarted(request, response, handler);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Optional<ScopeLevel> scopeLevel = this.getScopeLevel(handler);
        if (!scopeLevel.isPresent()) {
            return true;
        }
        String token = this.getToken(request);
        if(StringUtils.hasLength(token)) {
            throw new UnAuthenticatedException(10004);
        }
        // 标准 Bearer 开头
        if (!token.startsWith("Bearer")) {
            throw new UnAuthenticatedException(10004);
        }
        // 提取token
        String realToken = token.split(" ")[1];
        Optional<Map<String, Claim>> optionalStringClaimMap = JwtToken.getClaim(realToken);
        Map<String, Claim> map = optionalStringClaimMap.orElseThrow(() -> new UnAuthenticatedException(10004));
        Boolean valid = this.hasPermission(scopeLevel.get(), map);
        return  valid;
    }

    private Boolean hasPermission(ScopeLevel scopeLevel, Map<String, Claim> map) {
        Integer level = scopeLevel.value();
        Integer scope = map.get("scope").asInt();
        // 进入的权限大于固定权限 无权访问
        if (level > scope) {
            throw new ForbiddenException(10005);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        AsyncHandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        AsyncHandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
    // 获取对应的scope
    private Optional<ScopeLevel> getScopeLevel(Object handler) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            ScopeLevel scopeLevel = handlerMethod.getMethod().getAnnotation(ScopeLevel.class);
            if (scopeLevel == null) {
                return Optional.empty();
            }
            return  Optional.of(scopeLevel);
        }
        return Optional.empty();
    }
    // 获取token
    private String getToken(HttpServletRequest request) {
        return request.getHeader("Authorization");
    }

}
