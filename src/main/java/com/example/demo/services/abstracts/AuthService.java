package com.example.demo.services.abstracts;

import com.example.demo.services.dtos.requests.user.LoginRequest;
import com.example.demo.services.dtos.requests.user.RegisterRequest;

public interface AuthService {
    void register(RegisterRequest request);
    String login(LoginRequest request);
}
