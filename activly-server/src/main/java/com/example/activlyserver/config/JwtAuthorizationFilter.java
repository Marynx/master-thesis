package com.example.activlyserver.config;

import com.auth0.jwt.JWT;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

import static com.example.activlyserver.config.SecurityConstants.*;
import static com.example.activlyserver.config.SecurityConstants.TOKEN_PREFIX;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
    
    private final UserDetailsService userDetailsService;
    
    public JwtAuthorizationFilter(AuthenticationManager authenticationManager,UserDetailsService userDetailsService){
        super(authenticationManager);
        this.userDetailsService = userDetailsService;
    }
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        final String header = request.getHeader(HEADER_STRING);
    
        if ( header == null || !header.startsWith(TOKEN_PREFIX) ) {
            chain.doFilter(request, response);
            return;
        }
    
        final UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        SecurityContextHolder.getContext()
                .setAuthentication(authentication);
        chain.doFilter(request, response);
    }
    
    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        final String token = request.getHeader(HEADER_STRING);
        if ( token != null ) {
            final String user = JWT.require(HMAC512(SECRET.getBytes()))
                    .build()
                    .verify(token.replace(TOKEN_PREFIX, ""))
                    .getSubject();
            
            if ( user != null ) {
                final UserDetails userDetails = userDetailsService.loadUserByUsername(user);
                return new UsernamePasswordAuthenticationToken(userDetails.getUsername(), null, new ArrayList<>());
            }
        }
        return null;
    }
    
}
