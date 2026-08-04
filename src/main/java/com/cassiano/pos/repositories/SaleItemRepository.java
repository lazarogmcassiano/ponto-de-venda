package com.cassiano.pos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cassiano.pos.entities.SaleItem;

public interface SaleItemRepository extends JpaRepository<SaleItem, Long> {

}
