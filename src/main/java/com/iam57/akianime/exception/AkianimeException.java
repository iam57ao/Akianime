package com.iam57.akianime.exception;

import com.iam57.akianime.common.enums.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author iam57
 * @since 2024/6/28 14:23
 */
@Getter
@AllArgsConstructor
public class AkianimeException extends RuntimeException {
    private CodeEnum codeEnum;
}
