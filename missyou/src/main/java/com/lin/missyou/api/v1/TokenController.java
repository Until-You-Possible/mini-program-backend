package com.lin.missyou.api.v1;


import com.lin.missyou.dto.TokenDTO;
import com.lin.missyou.dto.VerifyTokenDTO;
import com.lin.missyou.dto.doubleTokenDTO;
import com.lin.missyou.exception.Http.NotFoundException;
import com.lin.missyou.service.WxAuthenticationService;
import com.lin.missyou.util.JwtToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "token")
public class TokenController {

    private final WxAuthenticationService wxAuthenticationService;
    public TokenController(WxAuthenticationService wxAuthenticationService) {
        this.wxAuthenticationService = wxAuthenticationService;
    }

    @PostMapping("/getToken")
    public Map<String, String> getToken(@RequestBody TokenDTO useData) {
        Map<String, String> map = new HashMap<>();
        String token = null;
        switch (useData.getType()) {
            case USER_WX:
                token = wxAuthenticationService.code2Session(useData.getAccount());
                break;
            case USER_Email:
                break;
            default:
                throw new NotFoundException(10003);
        }
        map.put("token", token);
        return map;
    }

    // 验证token
    @PostMapping("/verify")
    public Map<String, Boolean> verifyToken(@RequestBody VerifyTokenDTO tokenDTO) {
        // 去验证前端传过来的token
        String token = tokenDTO.getToken();
        Map<String, Boolean> map = new HashMap<>();
        map.put("is_valid", JwtToken.verifyToken(token));
        return map;
    }


}
