package com.reziz.miusched.service;

import com.reziz.miusched.model.UserModel;
import com.reziz.miusched.model.dto.UserCreateRequest;
import com.reziz.miusched.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserModel readUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public void createUser(UserCreateRequest userCreateRequest) {
        var userModel = new UserModel();
        Optional<UserModel> byUsername = userRepository.findByUsername(userCreateRequest.getUsername());
        if (byUsername.isPresent()) {
            throw new RuntimeException("User already registered. Please use different username.");
        }
        userModel.setUsername(userCreateRequest.getUsername());
        userModel.setPassword(passwordEncoder.encode(userCreateRequest.getPassword()));
        userModel.setRole(userCreateRequest.getRole());
        userRepository.save(userModel);
    }
}
