package com.lin.missyou.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.missyou.exception.Http.ParemeterExcepiton;
import com.lin.missyou.model.User;
import com.lin.missyou.repository.UserRepository;
import com.lin.missyou.util.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class WxAuthenticationService {

    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private UserRepository userRepository;

    @Value("${wx.code2session}")
    private String code2sessionUrl;
    @Value("${wx.appid}")
    private String appid;
    @Value("${wx.appsecret}")
    private String appsecret;

    public String code2Session(String code) {
        // 信息配置在yml里面
        // 去微信服务器验证code码
        String url = MessageFormat.format(this.code2sessionUrl, this.appid, this.appsecret, code);
        RestTemplate restTemplate = new RestTemplate();
        String sessionText = restTemplate.getForObject(url,String.class);
        Map<String, Object> session = new HashMap<>();
        try {
            session = mapper.readValue(sessionText, Map.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return this.registerUser(session);
    }

    public String registerUser(Map<String, Object> session) {
        String openid = (String) session.get("openid");
        if (openid == null) {
            throw new ParemeterExcepiton(20004);
        }
        Optional<User> optionalUser =  userRepository.findByOpenid(openid);
        // exist
        if (optionalUser.isPresent()) {
            // 返回jwt令牌
            return JwtToken.makeToken(optionalUser.get().getId());
        }
        // 获取的openid写入实体存入数据库
        User user  = User.builder().openid(openid).build();
        userRepository.save(user);
        Long uid = user.getId();
        // 返回jwt令牌
        return JwtToken.makeToken(uid);

    }

}
