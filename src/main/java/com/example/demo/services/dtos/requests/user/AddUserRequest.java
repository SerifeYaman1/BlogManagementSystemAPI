package com.example.demo.services.dtos.requests.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class AddUserRequest {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
}
