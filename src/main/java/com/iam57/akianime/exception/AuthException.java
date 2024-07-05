package com.iam57.akianime.exception;

import com.iam57.akianime.common.enums.CodeEnum;

/**
 * @author iam57
 * @since 2024/6/28 18:09
 */
public class AuthException extends AkianimeException {
    public AuthException(CodeEnum codeEnum) {
        super(codeEnum);
    }
}
