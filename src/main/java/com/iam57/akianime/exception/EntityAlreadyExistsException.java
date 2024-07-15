package com.iam57.akianime.exception;

import com.iam57.akianime.common.enums.CodeEnum;

import java.io.Serial;

/**
 * @author iam57
 * @since 2024/6/28 18:09
 */
public class EntityAlreadyExistsException extends AkianimeException {
    @Serial
    private static final long serialVersionUID = 6515479080376493454L;

    public EntityAlreadyExistsException(CodeEnum codeEnum) {
        super(codeEnum);
    }
}
