package com.lin.missyou.dto.validators;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TokenPasswordValidator implements ConstraintValidator<TokenPassword,String> {

    private Integer min;
    private Integer max;

    @Override
    public void initialize(TokenPassword constraintAnnotation) {
        this.max = constraintAnnotation.max();
        this.min = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        // isEmpty已经被遗弃
        if(StringUtils.hasLength(s)) {
            return true;
        }
        return s.length() >= this.min && s.length() <= this.max;
    }
}
