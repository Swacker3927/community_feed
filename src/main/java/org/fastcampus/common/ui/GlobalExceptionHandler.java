package org.fastcampus.common.ui;

import lombok.extern.slf4j.Slf4j;
import org.fastcampus.common.domain.exception.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Response<Void> handleException(Exception e) {
        log.error(e.getMessage());
        return Response.ERROR(ErrorCode.INVALID_INPUT_VALUE);
    }
}
