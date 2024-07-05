package com.iam57.akianime.annotation.validation;

import com.iam57.akianime.validator.UsernameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author iam57
 * @since 2024/7/5 14:34
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UsernameValidator.class})
public @interface ValidUsername {
    String message() default "用户名不符合规则!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    boolean unique() default false;
}
