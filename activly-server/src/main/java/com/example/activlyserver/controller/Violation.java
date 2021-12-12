package com.example.activlyserver.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Violation {
    
    private final String fieldName;
    
    private final String message;
    
}
