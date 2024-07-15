package com.example.demo.core.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {
    private final long EXPIRATION=600000;
    private final String SECRET_KEY="14e991d7a4c4fc48546e85ae34d93da7d2dd9c3db8c6164a98167a0b8534d1546bb61a4778ca7b9cfca45513bd3ad364102980ffa92c80a491512fdd8561bb0a";
    //Anahtar kısım String key kısmı hem string hem de int olduğu için object türü verilir.
    //Kullanıcı adı ve extra bilgiler eklenir.
    public String generateToken(String userName, Map<String, Object> extraClaims) {
         String token= Jwts
                 .builder()
                 .setIssuedAt(new Date(System.currentTimeMillis())) //Tokenın oluştulma tarihi
                 .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION)) //Tokenın bitis tarihi
                 .setClaims(extraClaims) //Diğer bilgiler
                 .setSubject(userName) //Kullanıcı adı
                 .signWith(getSignKey(), SignatureAlgorithm.HS256) //Tokenı anahtar ile imzaladığımız kısımdır.İmza algoritması seçilebilir.
                 .compact();
        return token;
    }
    //Yukarıda kullanılan String değeri byte'a dönüştürüyoruz.
    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes); //Anahtar üretilir.
    }
}
