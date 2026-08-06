package com.cassiano.pos.services;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.cassiano.pos.security.UserDetailsImpl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(UserDetailsImpl user) {

        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());

        return Jwts.builder()

                .subject(user.getUsername())

                .claim("role",
                        user.getRole())
                .claim("permissions",

                        user.getAuthorities()

                                .stream()

                                .map(GrantedAuthority::getAuthority)

                                .toList())

                .issuedAt(new Date())

                .expiration(new Date(

                        System.currentTimeMillis()
                                + 3600000))

                .signWith(key)

                .compact();
    }

}
