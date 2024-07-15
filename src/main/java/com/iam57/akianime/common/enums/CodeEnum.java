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
    UNAUTHORIZED_ACCESS(-2005, "无权限访问!"),

    FAVORITE_ALREADY_EXISTS(-3001, "收藏已经存在!"),
    EPISODE_COUNT_INVALID(-3002, "不合理的集数!"),
    FAVORITE_NOT_FOUND(-3003, "收藏不存在!"),

    ANIMATION_NOT_FOUND(-3101, "动画不存在!");


    private final Integer code;
    private final String msg;
}
