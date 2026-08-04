package com.cassiano.pos.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cassiano.pos.dto.request.UserRequestDTO;
import com.cassiano.pos.dto.response.UserResponseDTO;
import com.cassiano.pos.entities.User;
import com.cassiano.pos.mappers.UserMapper;
import com.cassiano.pos.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserResponseDTO create(UserRequestDTO dto) {
        User user = userMapper.toEntity(dto);

        user.setActive(true);

        userRepository.save(user);

        return userMapper.toString(user);
    }

    public void disable(UUID id) {

        User user = userRepository.findById(id)
                .orElseThrow();

        user.setActive(false);

        userRepository.save(user);

    }

    public UserResponseDTO update(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not find"));
        return userMapper.toString(user);
    }
}
