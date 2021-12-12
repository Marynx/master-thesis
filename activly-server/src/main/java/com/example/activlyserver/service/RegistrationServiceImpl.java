package com.example.activlyserver.service;

import com.example.activlyserver.dto.AccountDTO;
import com.example.activlyserver.entity.User;
import com.example.activlyserver.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService{
    
    private final UserRepository userRepository;
    
    private final PasswordEncoder passwordEncoder;
    
    @Override
    public User register(@NonNull AccountDTO accountDTO) {
        User userToSave = new User();
        userToSave.setUsername(accountDTO.getUsername());
        userToSave.setPassword(passwordEncoder.encode(accountDTO.getPassword()));
        userToSave.setEmail(accountDTO.getEmail());
        userToSave.setPhoneNumber(accountDTO.getPhoneNumber());
        return userRepository.save(userToSave);
    }
    
    @Override
    public boolean accountExistsByEmail(@NonNull String email) {
        return false;
    }
    
    @Override
    public boolean accountExistsByUsername(@NonNull String username) {
        return false;
    }
    
}
