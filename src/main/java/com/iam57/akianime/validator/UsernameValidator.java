package com.iam57.akianime.validator;

import com.iam57.akianime.annotation.validation.ValidUsername;
import com.iam57.akianime.service.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author iam57
 * @since 2024/7/5 14:36
 */
public class UsernameValidator implements ConstraintValidator<ValidUsername, String> {
    @Autowired
    private UserService userService;

    private boolean unique;

    @Override
    public void initialize(ValidUsername constraintAnnotation) {
        this.unique = constraintAnnotation.unique();
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        constraintValidatorContext.disableDefaultConstraintViolation();
        if (username == null) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("用户名不能为空!").addConstraintViolation();
            return false;
        }
        if (username.isEmpty()) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("用户名不能为空!").addConstraintViolation();
            return false;
        }
        if (!username.matches("^[a-zA-Z0-9]+$")) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("用户名只能包含字母或数字!").addConstraintViolation();
            return false;
        }
        if (unique && !(userService.getByUsername(username) == null)) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("用户名已存在!").addConstraintViolation();
            return false;
        }
        return true;
    }
}
