package com.szarotka.webfluxdemo.errorhandling;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = ValidationException.class)
    public ResponseEntity<ErrorMessage> handleException(ValidationException ex) {
        return new ResponseEntity<>(new ErrorMessage(ex.getMessage()), ex.getHttpStatus());
    }
}
