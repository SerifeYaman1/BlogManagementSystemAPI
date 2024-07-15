package com.example.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Table(name="authors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="username" , unique = true)
    private String username;
    @NotBlank
    @NonNull
    @Column(name="email", unique = true)
    private String email;
    @Column(name="password_hash")
    private String password_hash;
    @OneToMany(mappedBy = "author")
    private List<BlogPost> blogPosts;
}
