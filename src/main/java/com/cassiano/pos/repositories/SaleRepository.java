package com.cassiano.pos.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cassiano.pos.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, UUID> {

}
