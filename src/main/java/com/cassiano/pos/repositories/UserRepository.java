package com.cassiano.pos.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cassiano.pos.entities.User;

public interface UserRepository extends JpaRepository<User, UUID> {

}
