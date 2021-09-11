package com.lin.missyou.api.v1;


import com.lin.missyou.dto.TokenDTO;
import com.lin.missyou.exception.Http.NotFoundException;
import com.lin.missyou.service.WxAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "token")
public class TokenController {

    @Autowired
    private WxAuthenticationService wxAuthenticationService;

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


}
