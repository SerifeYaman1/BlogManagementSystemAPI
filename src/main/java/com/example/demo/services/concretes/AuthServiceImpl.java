package com.example.demo.services.concretes;

import com.example.demo.core.services.JwtService;
import com.example.demo.core.utils.result.DataResult;
import com.example.demo.core.utils.result.ErrorDataResult;
import com.example.demo.core.utils.result.SuccessDataResult;
import com.example.demo.entities.User;
import com.example.demo.services.abstracts.AuthService;
import com.example.demo.services.abstracts.UserService;
import com.example.demo.services.dtos.requests.user.LoginRequest;
import com.example.demo.services.dtos.requests.user.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public DataResult<String> login(LoginRequest request) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        if (authentication.isAuthenticated()) {
            return new SuccessDataResult<>(jwtService.generateToken(request.getUsername()),"Giriş yapıldı");
        }
        return new ErrorDataResult<>("Kullanıcı adı ya da şifre yanlış");
    }
    @Override
    public void register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .authorities(request.getRoles())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        userService.add(user);
    }
}
