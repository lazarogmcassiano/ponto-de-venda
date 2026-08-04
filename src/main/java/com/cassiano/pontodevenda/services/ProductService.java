package com.cassiano.pontodevenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cassiano.pontodevenda.dto.request.ProductRequestDTO;
import com.cassiano.pontodevenda.dto.response.ProductResponseDTO;
import com.cassiano.pontodevenda.entities.Product;
import com.cassiano.pontodevenda.mappers.ProductMapper;
import com.cassiano.pontodevenda.repositories.ProductRepository;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductMapper mapper;

    public ProductResponseDTO save(ProductRequestDTO dto) {

        Product product = mapper.toEntity(dto);

        product.setCategory(
                categoryService.findById(dto.getCategoryId()));

        Product saved = productRepository.save(product);

        return mapper.toResponse(saved);
    }

    public List<ProductResponseDTO> findAll() {

        return productRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public Product findById(Long id) {

        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public ProductResponseDTO update(Long id, ProductRequestDTO dto) {

        Product product = findById(id);

        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setInventoryQuantity(dto.getInventoryQuantity());
        product.setBarcode(dto.getBarcode());

        product.setCategory(
                categoryService.findById(dto.getCategoryId()));

        Product updated = productRepository.save(product);

        return mapper.toResponse(updated);
    }

    public void delete(Long id) {

        Product product = findById(id);

        productRepository.delete(product);
    }

    public Product findByName(String name) {

        return productRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException(
                        "Product not found"));
    }

    public ProductResponseDTO findByBarcode(String barcode) {

        Product product = productRepository.findByBarcode(barcode)
                .orElseThrow(() -> new RuntimeException(
                        "Product not found"));

        return mapper.toResponse(product);
    }
}
