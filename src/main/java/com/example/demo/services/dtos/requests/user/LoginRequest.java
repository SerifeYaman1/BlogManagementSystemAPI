package com.example.demo.services.dtos.requests.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class LoginRequest {
    private String email;
    private String password;
}