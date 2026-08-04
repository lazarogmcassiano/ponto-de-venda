package com.cassiano.pos.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cassiano.pos.entities.Permission;

public interface PermissionRepository extends JpaRepository<Permission, UUID> {

}
