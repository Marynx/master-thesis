package com.example.activlyserver.config;

public interface SecurityConstants {
    
    String SECRET = "activlyserver";
    
    long EXPIRATION_TIME = 86400000; // 24h
    
    String TOKEN_PREFIX = "Bearer ";
    
    String HEADER_STRING = "Authorization";
    
}
