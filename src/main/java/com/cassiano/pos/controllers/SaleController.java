package com.cassiano.pos.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cassiano.pos.dto.request.SaleRequestDTO;
import com.cassiano.pos.dto.response.SaleResponseDTO;
import com.cassiano.pos.services.SaleService;

@RestController
@RequestMapping("/sales")
@CrossOrigin("*")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping
    public ResponseEntity<SaleResponseDTO> processSale(
            @RequestBody SaleRequestDTO saleDTO) {

        SaleResponseDTO sale = saleService.processSale(saleDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(sale);
    }

    @GetMapping
    public ResponseEntity<List<SaleResponseDTO>> findAll() {

        return ResponseEntity.ok(
                saleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleResponseDTO> findById(
            @PathVariable UUID id) {

        return ResponseEntity.ok(
                saleService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable UUID id) {

        saleService.delete(id);

        return ResponseEntity
                .noContent()
                .build();
    }
}
