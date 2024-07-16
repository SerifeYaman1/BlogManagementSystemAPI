package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;


@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//User entitisi Spring security ile entegre bir şekilde çalışabilmesi için UserDetails sınıfını implemente ediliyor.
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password_hash")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @JoinTable(name = "roles",joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private List<Role> authorities;

    //Rol sistemi burada yönetilir.
    /*@Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return email;
    }
    */
    //Kullanılmayacaksa true olarak kullanılır.
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {//Hesabın kilitlenmesi
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { //Hesabın süresinin geçmesi
        return true;
    }

    @Override
    public boolean isEnabled() { //Hesabın devre dışı bırakılması
        return true;
    }
}
