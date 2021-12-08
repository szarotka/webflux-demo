package com.szarotka.webfluxdemo.errorhandling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Builder
@Getter
public class ValidationException extends RuntimeException {

    private final HttpStatus httpStatus;
    private final String message;
}
