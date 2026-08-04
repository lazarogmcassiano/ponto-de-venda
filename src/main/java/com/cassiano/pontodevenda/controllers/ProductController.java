package com.cassiano.pontodevenda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cassiano.pontodevenda.dto.request.ProductRequestDTO;
import com.cassiano.pontodevenda.dto.response.ProductResponseDTO;
import com.cassiano.pontodevenda.entities.Product;
import com.cassiano.pontodevenda.services.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDTO> save(
            @RequestBody ProductRequestDTO dto) {

        ProductResponseDTO product = productService.save(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(product);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> findAll() {

        return ResponseEntity.ok(
                productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                productService.findById(id));
    }

    @GetMapping("/barcode/{barcode}")
    public ResponseEntity<ProductResponseDTO> findByBarcode(
            @PathVariable String barcode) {

        return ResponseEntity.ok(
                productService.findByBarcode(barcode));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> update(
            @PathVariable Long id,
            @RequestBody ProductRequestDTO dto) {

        ProductResponseDTO product = productService.update(id, dto);

        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        productService.delete(id);

        return ResponseEntity
                .noContent()
                .build();
    }
}
