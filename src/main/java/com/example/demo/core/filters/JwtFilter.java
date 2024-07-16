package com.example.demo.core.filters;

import com.example.demo.core.services.JwtService;
import com.example.demo.services.abstracts.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
//Sistemde devreye girebilmesi için
@Component
@AllArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
    private JwtService jwtService;
    private UserService userService;
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        String jwtHeader=request.getHeader("Authorization"); //jwt'inin header kısmının okunması


        if(jwtHeader != null && jwtHeader.startsWith("Bearer "))
        {
            // ..
            String jwt = jwtHeader.substring(7); // eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmdAc3RyaW5nLmNvbSIsImlhdCI6MTcwNTQ5NTk5NiwiZXhwIjoxNzA1NDk2NTk2fQ.dKpaT7SgmT7gO_wEqUzdXb1LKqQe4aZAq-8TMqOMyuA
            String username = jwtService.extractUser(jwt);

            if(username!=null)
            {
                UserDetails user = userService.loadUserByUsername(username);
                if(jwtService.validateToken(jwt, user))
                {
                    //her şey başarılı
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }
        filterChain.doFilter(request,response);
    }
}
