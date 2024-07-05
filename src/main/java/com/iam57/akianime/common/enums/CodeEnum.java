package com.iam57.akianime.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author iam57
 * @since 2024/6/28 14:34
 */
@Getter
@AllArgsConstructor
public enum CodeEnum {
    ERROR(-1, "未知错误!"),

    VALIDATION_ERROR(-1001, "参数不合法!"),

    USER_NOT_FOUND(-2001, "用户不存在!"),
    PASSWORD_INCORRECT(-2002, "密码错误!"),
    USER_ALREADY_EXISTS(-2003, "用户已存在!"),
    NOT_LOGGED_IN(-2004, "无效的Token!"),
    UNAUTHORIZED_ACCESS(-2005, "无权限访问!");


    private final Integer code;
    private final String msg;
}
