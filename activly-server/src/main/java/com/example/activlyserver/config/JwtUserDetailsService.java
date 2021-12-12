package com.example.activlyserver.config;

import com.example.activlyserver.entity.User;
import com.example.activlyserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {
    
    private final UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<User> user = userRepository.findByUsername(username);
        if ( !user.isPresent() ) {
            final String message = String.format("User with username: %s was not found", username);
            log.debug(message);
            throw new UsernameNotFoundException(message);
        }
        
        final User foundUser = user.get();
        
        return new org.springframework.security.core.userdetails.User(username, foundUser.getPassword(), new ArrayList<>());
    }
    
}
