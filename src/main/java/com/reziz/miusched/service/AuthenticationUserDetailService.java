package com.reziz.miusched.service;

import com.reziz.miusched.model.UserModel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationUserDetailService implements UserDetailsService {

    private final UserService userService;

    @Override public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = userService.readUserByUsername(username);
        if (userModel == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(userModel.getUsername(), userModel.getPassword(), Collections.emptyList());
    }
}
