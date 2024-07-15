package com.iam57.akianime.exception;

import com.iam57.akianime.common.enums.CodeEnum;

import java.io.Serial;

/**
 * @author iam57
 * @since 2024/7/8 10:48
 */
public class InvalidValueException extends AkianimeException {
    @Serial
    private static final long serialVersionUID = 855461399666407194L;

    public InvalidValueException(CodeEnum codeEnum) {
        super(codeEnum);
    }
}
