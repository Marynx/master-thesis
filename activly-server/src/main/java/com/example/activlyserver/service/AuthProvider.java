package com.example.activlyserver.service;

import com.example.activlyserver.entity.User;

public interface AuthProvider {
    
    String getUserLogin();
    
    User getUserEntity();
    
}
