package com.cassiano.pos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cassiano.pos.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Optional<Category> findByName(String name);

}
