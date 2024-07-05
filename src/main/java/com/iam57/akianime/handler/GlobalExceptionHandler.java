package com.iam57.akianime.handler;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.iam57.akianime.common.enums.CodeEnum;
import com.iam57.akianime.exception.AkianimeException;
import com.iam57.akianime.common.result.ApiResult;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author iam57
 * @since 2024/6/28 16:52
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public ApiResult<Void> otherException(RuntimeException exception) {
        exception.printStackTrace();
        return ApiResult.failed(CodeEnum.ERROR);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(AkianimeException.class)
    public ApiResult<Void> apiException(AkianimeException exception) {
        return ApiResult.failed(exception.getCodeEnum());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(JWTVerificationException.class)
    public ApiResult<Void> jwtException() {
        return ApiResult.failed(CodeEnum.NOT_LOGGED_IN);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResult<Map<String, String>> validateException(MethodArgumentNotValidException exception) {
        Map<String, String> errorMap = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach(objectError -> {
            FieldError fieldError = (FieldError) objectError;
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return ApiResult.failed(CodeEnum.VALIDATION_ERROR, errorMap);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ApiResult<Map<String, String>> validateException(ConstraintViolationException exception) {
        Map<String, String> errorMap = new HashMap<>();
        exception.getConstraintViolations().forEach(constraintViolation -> {
            errorMap.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
        });
        return ApiResult.failed(CodeEnum.VALIDATION_ERROR, errorMap);
    }
}
