package com.example.activlyserver.service;

import com.example.activlyserver.entity.User;
import com.example.activlyserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthProviderImpl implements AuthProvider{
    
    private final UserRepository userRepository;
    
    @Override
    public String getUserLogin() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
    
    @Override
    public User getUserEntity() {
        return userRepository.findByUsername(getUserLogin()).get();
    }
    
}
