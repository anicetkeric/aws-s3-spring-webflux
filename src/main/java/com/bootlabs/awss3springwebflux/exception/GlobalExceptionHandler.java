package com.bootlabs.awss3springwebflux.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.buffer.DataBufferLimitException;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.time.Instant;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FileValidatorException.class)
    public ErrorResponse handleFileValidatorException(FileValidatorException e) {
        return ErrorResponse.builder(e, HttpStatus.BAD_REQUEST, e.getMessage())
                .title("File Validator Exception")
                .type(URI.create("https://api.error.code"))
                .property("timestamp", Instant.now())
                .build();
    }
    @ExceptionHandler(DataBufferLimitException.class)
    public ErrorResponse handleLimitException(DataBufferLimitException e) {
        return ErrorResponse.builder(e, HttpStatus.BAD_REQUEST, e.getMessage())
                .title("File Limit Exception")
                .type(URI.create("https://api.error.code"))
                .property("timestamp", Instant.now())
                .build();
    }


}
