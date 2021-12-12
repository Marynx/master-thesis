package com.example.activlyserver.dto;

import lombok.Value;

import javax.validation.constraints.*;

@Value
public class AccountDTO {
    
    @NotBlank
    String username;
    
    @NotBlank
    String password;
    
    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Bad email format")
    String email;
    
    @NotEmpty(message = "Phone number must not be empty")
    @Pattern(regexp="(^$|[0-9]{9})", message = "Bad phone number format. Correct one example: 123123123")
    String phoneNumber;
    
}
