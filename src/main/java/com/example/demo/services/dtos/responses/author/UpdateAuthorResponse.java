package com.example.demo.services.dtos.responses.author;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class UpdateAuthorResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password_hash;
}
