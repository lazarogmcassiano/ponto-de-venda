package com.cassiano.pos.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cassiano.pos.dto.request.LoginRequest;
import com.cassiano.pos.dto.response.LoginResponse;
import com.cassiano.pos.security.UserDetailsImpl;
import com.cassiano.pos.services.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    public AuthController(
            AuthenticationManager authenticationManager,
            JwtService jwtService) {

        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request) {

        Authentication authentication = authenticationManager.authenticate(

                new UsernamePasswordAuthenticationToken(

                        request.barcode(),

                        request.password()

                ));

        UserDetailsImpl user = (UserDetailsImpl) authentication.getPrincipal();

        String token = jwtService.generateToken(user);

        return ResponseEntity.ok(

                new LoginResponse(

                        token,

                        user.getUsername(),

                        user.getRole())

        );
    }

}
