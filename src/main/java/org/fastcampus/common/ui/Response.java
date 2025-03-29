package org.fastcampus.common.ui;

import org.fastcampus.common.domain.exception.ErrorCode;

public record Response<T>(Integer code, String message, T value) {
    public static <T> Response<T> OK(T value) {
        return new Response<>(200, "OK", value);
    }

    public static <T> Response<T> ERROR(ErrorCode error) {
        return new Response<>(error.getCode(), error.getMessage(), null);
    }
}
