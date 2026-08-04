package com.cassiano.pontodevenda.mappers;

import org.springframework.stereotype.Component;

import com.cassiano.pontodevenda.dto.request.CategoryRequestDTO;
import com.cassiano.pontodevenda.dto.response.CategoryResponseDTO;
import com.cassiano.pontodevenda.entities.Category;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryRequestDTO dto) {

        Category category = new Category();

        category.setName(dto.getName());

        return category;
    }

    public CategoryResponseDTO toResponse(Category category) {

        return new CategoryResponseDTO(
                category.getId(),
                category.getName());
    }
}
