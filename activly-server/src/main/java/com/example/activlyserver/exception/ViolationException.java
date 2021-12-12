package com.example.activlyserver.exception;

import lombok.Getter;

@Getter
public class ViolationException extends RuntimeException{
    
    private final String field;
    
    public ViolationException(String field, String message){
        super(message);
        this.field=field;
    }
    
}
