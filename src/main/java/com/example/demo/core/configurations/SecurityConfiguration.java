package com.example.demo.core.configurations;

import com.example.demo.services.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {
    private  final UserService userService;
    @Bean
    public PasswordEncoder passwordEncoder() {
        //Uygulamanın genelinde burada return edilen şifreleme algoritması kullanılır.
        return new BCryptPasswordEncoder();
    }
    //Bize verilen girişi devredışı bırakmak için,security filtresinin nasıl çalışacağını entegre ediyoruz.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        .csrf(AbstractHttpConfigurer::disable) //csrf isteklerini devredışı bırakıyoruz.
        .authorizeHttpRequests(req->req.anyRequest().permitAll())//tüm istekleri kabul et
        .httpBasic(AbstractHttpConfigurer::disable);
        return http.build(); //devredışı bırakıyoruz.
    }
    //AuthenticationProbider olarak Dao kullanacağımızı burada belirleriz. (Veritabanı üzerinden gideceğimiz için)
    @Bean
    public AuthenticationProvider authenticationProvider() {
       DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
       provider.setPasswordEncoder(passwordEncoder()); //Provider şifreleme için passwordEncoder kullancak.
       provider.setUserDetailsService(userService); //Servis olarak UserService kullanılacak.
       return provider;
    }
    //AuthenticationManager'ı da Bean olarak buraya eklememiz gerekir.Şifreyi karşılaştırmak için kullanılır.
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)throws Exception
    {
        return config.getAuthenticationManager();//Yukarıda kullanılan provider'ın metodu.
    }
}