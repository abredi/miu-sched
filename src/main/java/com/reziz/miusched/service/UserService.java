package com.reziz.miusched.service;


import com.reziz.miusched.model.UserModel;
import com.reziz.miusched.model.request.UserCreateRequest;
import com.reziz.miusched.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserModel readUserByUsername (String username) {
        return userRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new);
    }

    public void createUser(UserCreateRequest userCreateRequest) {
        UserModel userModel = new UserModel();
        Optional<UserModel> byUsername = userRepository.findByUsername(userCreateRequest.getUsername());
        if (byUsername.isPresent()) {
            throw new RuntimeException("UserModel already registered. Please use different username.");
        }
        userModel.setUsername(userCreateRequest.getUsername());
        userModel.setRole(userCreateRequest.getRole());
        userModel.setPassword(passwordEncoder.encode(userCreateRequest.getPassword()));
        userRepository.save(userModel);
    }
}
