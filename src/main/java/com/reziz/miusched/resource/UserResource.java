package com.reziz.miusched.resource;

import com.reziz.miusched.model.request.UserCreateRequest;
import com.reziz.miusched.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserResource {
    private final UserService userService;
    @PostMapping
    private ResponseEntity<UserCreateRequest> create(@RequestBody UserCreateRequest user) {
        userService.createUser(user);
        return ResponseEntity.ok().build();
    }
}
