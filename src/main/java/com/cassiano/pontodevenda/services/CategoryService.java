package com.cassiano.pontodevenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cassiano.pontodevenda.dto.request.CategoryRequestDTO;
import com.cassiano.pontodevenda.dto.response.CategoryResponseDTO;
import com.cassiano.pontodevenda.entities.Category;
import com.cassiano.pontodevenda.mappers.CategoryMapper;
import com.cassiano.pontodevenda.repositories.CategoryRepository;

@Transactional
@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryResponseDTO save(CategoryRequestDTO dto) {

        Category category = categoryRepository.findByName(dto.getName())
                .orElseGet(() -> {

                    Category newCategory = new Category();
                    newCategory.setName(dto.getName());

                    return categoryRepository.save(newCategory);
                });

        return categoryMapper.toResponse(category);
    }

    public List<CategoryResponseDTO> findAll() {

        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toResponse)
                .toList();
    }

    public Category findById(Integer id) {

        if (id == null) {
            return findDefaultCategory();
        }

        return categoryRepository.findById(id)
                .orElseGet(this::findDefaultCategory);
    }

    private Category findDefaultCategory() {

        return categoryRepository.findByName("Others")
                .orElseThrow(() -> new RuntimeException(
                        "Default category 'Others' not registered."));
    }

    public Category findByName(String name) {

        return categoryRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException(
                        "Category not found."));
    }
}
