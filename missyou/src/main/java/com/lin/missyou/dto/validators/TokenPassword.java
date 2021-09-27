package com.lin.missyou.dto.validators;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Constraint(validatedBy = TokenPasswordValidator.class)
public @interface TokenPassword {
    String message() default "字段不符合要求";
    int min() default 0;
    int max() default 8;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
