package com.cassiano.pontodevenda.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cassiano.pontodevenda.entities.User;

public interface UserRepository extends JpaRepository<User, UUID> {

}
