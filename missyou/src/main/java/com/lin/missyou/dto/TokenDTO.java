package com.lin.missyou.dto;


import com.lin.missyou.core.enumeration.LoginType;
import com.lin.missyou.dto.validators.TokenPassword;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TokenDTO {
    @NotBlank(message = "Account 不允许为空")
    private String account;
    @TokenPassword(min = 6, max = 30, message = "{token.password}")
    private String password;
    private LoginType loginType;
}
