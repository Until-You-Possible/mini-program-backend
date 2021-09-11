package com.lin.missyou.core;

import com.lin.missyou.core.configuration.ExceptionCodeConfiguration;
import com.lin.missyou.exception.Http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalHttpExceptionAdvice {

    @Autowired
    private ExceptionCodeConfiguration codeConfiguration;

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public UnifyResponse handleException(HttpServletRequest request, Exception e) {
        String url = request.getRequestURI();
        String method = request.getMethod();
        return new UnifyResponse(9999, "server error", method + "" + url);
    }

    @ExceptionHandler(value = HttpException.class)
    public ResponseEntity<UnifyResponse> handleHttpException(HttpServletRequest request, HttpException e) {
        String url = request.getRequestURI();
        String method = request.getMethod();
        HttpHeaders httpHeaders  = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpStatus httpStatus  = HttpStatus.resolve(e.getHttpStatusCode());
        UnifyResponse unifyResponse = new UnifyResponse(e.getCode(), codeConfiguration.getMessage(e.getCode()), method + " " + url);
        if (httpStatus == null) {
            return new ResponseEntity<>(unifyResponse, httpHeaders, 500);
        }
        return new ResponseEntity<>(unifyResponse, httpHeaders, httpStatus);

    }
}
