package com.cassiano.pontodevenda.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cassiano.pontodevenda.entities.Role;

public interface RoleRepository extends JpaRepository<Role, UUID> {

}
