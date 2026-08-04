package com.cassiano.pos.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cassiano.pos.dto.request.UserRequestDTO;
import com.cassiano.pos.dto.response.UserResponseDTO;
import com.cassiano.pos.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@RequestBody UserRequestDTO dto) {

        return ResponseEntity.ok(userService.create(dto));
    }

    @PutMapping
    public ResponseEntity<UserResponseDTO> update(@PathVariable UUID id) {

        return ResponseEntity.ok(userService.update(id));
    }

}
