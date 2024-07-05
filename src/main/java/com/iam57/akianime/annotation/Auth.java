package com.iam57.akianime.annotation;

import com.iam57.akianime.common.enums.RoleEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author iam57
 * @since 2024/7/4 14:08
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Auth {
    RoleEnum[] role() default {RoleEnum.USER, RoleEnum.ADMIN, RoleEnum.SUPER};
}
