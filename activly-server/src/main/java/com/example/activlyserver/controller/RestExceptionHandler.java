package com.example.activlyserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RestExceptionHandler {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    List<Violation> onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<Violation> violations = new ArrayList<>();
        for ( FieldError fieldError : e.getBindingResult().getFieldErrors() ) {
            violations.add(new Violation(fieldError.getField(), fieldError.getDefaultMessage()));
        }
        return violations;
    }
    
}
