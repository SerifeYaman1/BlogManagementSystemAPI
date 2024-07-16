package com.example.demo.controllers;

import com.example.demo.core.utils.result.DataResult;
import com.example.demo.core.utils.result.SuccessDataResult;
import com.example.demo.services.abstracts.AuthService;
import com.example.demo.services.dtos.requests.user.LoginRequest;
import com.example.demo.services.dtos.requests.user.RegisterRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @PostMapping("/register")
    public void register(@RequestBody RegisterRequest request){
        authService.register(request);
    }
    @PostMapping("/login")
    public DataResult<String> login(@RequestBody LoginRequest request){
        return authService.login(request);
    }
}
