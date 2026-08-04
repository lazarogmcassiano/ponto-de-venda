package com.cassiano.pos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cassiano.pos.dto.request.CategoryRequestDTO;
import com.cassiano.pos.dto.response.CategoryResponseDTO;
import com.cassiano.pos.services.CategoryService;

@RestController
@RequestMapping("/categories")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(
            @RequestBody CategoryRequestDTO dto) {

        return ResponseEntity.ok(
                categoryService.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> findCategories() {

        return ResponseEntity.ok(
                categoryService.findAll());
    }
}
