package com.example.activlyserver.controller;

import com.example.activlyserver.dto.AccountDTO;
import com.example.activlyserver.entity.User;
import com.example.activlyserver.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = RegistrationService.REGISTRATION_PREFIX)
@RequiredArgsConstructor
public class RegistrationController {
    
    private final RegistrationService registrationService;
    
    @PostMapping
    public User register(@Valid @RequestBody AccountDTO accountDTO){
        return registrationService.register(accountDTO);
    }
    
    
}
