package com.example.demo.services.abstracts;

import com.example.demo.core.utils.result.DataResult;
import com.example.demo.services.dtos.requests.user.LoginRequest;
import com.example.demo.services.dtos.requests.user.RegisterRequest;

public interface AuthService {
    void register(RegisterRequest request);
    DataResult<String> login(LoginRequest request);
}
