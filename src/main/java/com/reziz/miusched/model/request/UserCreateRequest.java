package com.reziz.miusched.model.request;

import lombok.Data;

@Data
public class UserCreateRequest {
    private String username;
    private String password;
}