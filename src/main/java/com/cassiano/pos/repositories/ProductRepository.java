package com.cassiano.pos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cassiano.pos.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String nome);

    Optional<Product> findByBarcode(String barcode);

}
