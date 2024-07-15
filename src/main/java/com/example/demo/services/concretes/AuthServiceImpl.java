package com.example.demo.services.concretes;

import com.example.demo.core.services.JwtService;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.abstracts.AuthService;
import com.example.demo.services.dtos.requests.user.LoginRequest;
import com.example.demo.services.dtos.requests.user.RegisterRequest;
import com.example.demo.services.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private  final PasswordEncoder passwordEncoder;
    private final  AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public void register(RegisterRequest request) {
        User user= UserMapper.INSTANCE.registerRequestToUser(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
    @Override
    public String login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı: " + request.getEmail()));
        //AuthenticationManager sayesinde kullanıcının verdiği sifreyi kontrol ederek karşılaştırma yapacak.
        Authentication authentication=
                authenticationManager
                        .authenticate(
                                new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword())
                        );
        if(!authentication.isAuthenticated()){
            throw new RuntimeException("Şifre ya da email yanlış");
        }
        return jwtService.generateToken(user.getUsername(),null);
    }
}
