package com.cassiano.pontodevenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cassiano.pontodevenda.entities.SaleItem;

public interface SaleItemRepository extends JpaRepository<SaleItem, Long> {

}
