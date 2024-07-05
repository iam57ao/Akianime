package com.iam57.akianime.common.result;

import com.iam57.akianime.common.enums.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author iam57
 * @since 2024/6/28 14:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResult<T> {
    private int code;
    private String msg;
    private T data;

    public static <T> ApiResult<T> success() {
        return new ApiResult<>();
    }

    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<>(0, null, data);
    }

    public static <T> ApiResult<T> failed(CodeEnum codeEnum) {
        return new ApiResult<>(codeEnum.getCode(), codeEnum.getMsg(), null);
    }

    public static <T> ApiResult<T> failed(CodeEnum codeEnum, T data) {
        return new ApiResult<>(codeEnum.getCode(), codeEnum.getMsg(), data);
    }
}
