package com.example.activlyserver.service;

import com.example.activlyserver.dto.AccountDTO;
import com.example.activlyserver.entity.User;
import lombok.NonNull;

public interface RegistrationService {
    
    String REGISTRATION_PREFIX = "/register";
    
    String FIND_BY_USERNAME = "/checkByUsername/{username}";
    
    User register(@NonNull AccountDTO accountDTO);
    
    boolean accountExistsByEmail(@NonNull String email);
    
    boolean accountExistsByUsername(@NonNull String username);
    
}
