package com.example.activlyserver.dto;

import lombok.Value;

import javax.validation.constraints.NotEmpty;

@Value
public class ActivityDTO {
    
    @NotEmpty
    String username;
    
    @NotEmpty
    String discipline;
    
    @NotEmpty
    String place;
    
    @NotEmpty
    String time;
    
}
