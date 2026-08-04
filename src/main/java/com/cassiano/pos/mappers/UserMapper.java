package com.cassiano.pos.mappers;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cassiano.pos.dto.request.UserRequestDTO;
import com.cassiano.pos.dto.response.UserResponseDTO;
import com.cassiano.pos.entities.Permission;
import com.cassiano.pos.entities.Role;
import com.cassiano.pos.entities.User;
import com.cassiano.pos.repositories.PermissionRepository;
import com.cassiano.pos.repositories.RoleRepository;

@Component
public class UserMapper {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    public User toEntity(UserRequestDTO dto) {

        User user = new User();

        user.setName(dto.getName());
        user.setBarcode(dto.getBarcode());
        user.setPassword(dto.getPassword());
        user.setActive(dto.getActive());

        Role role = roleRepository.findById(dto.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role não encontrada"));

        user.setRole(role);

        Set<Permission> permissions = dto.getPermissionIds()
                .stream()
                .map(id -> permissionRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Permissão não encontrada")))
                .collect(Collectors.toSet());

        user.setExtraPermissions(permissions);

        return user;
    }

    public UserResponseDTO toString(User user) {
        UserResponseDTO dto = new UserResponseDTO();

        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setBarcode(user.getBarcode());
        dto.setActive(user.getActive());

        dto.setRole(
                Optional.ofNullable(user.getRole())
                        .map(Role::getName)
                        .orElse(null));

        dto.setPermissions(
                Optional.ofNullable(user.getExtraPermissions())
                        .orElse(Collections.emptySet())
                        .stream()
                        .map(Permission::getName)
                        .collect(Collectors.toSet()));

        return dto;
    }
}
