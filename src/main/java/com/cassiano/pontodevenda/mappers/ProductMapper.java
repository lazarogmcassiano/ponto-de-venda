package com.cassiano.pontodevenda.mappers;

import org.springframework.stereotype.Component;

import com.cassiano.pontodevenda.dto.request.ProductRequestDTO;
import com.cassiano.pontodevenda.dto.response.ProductResponseDTO;
import com.cassiano.pontodevenda.entities.Product;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequestDTO dto) {

        Product product = new Product();

        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setInventoryQuantity(dto.getInventoryQuantity());
        product.setBarcode(dto.getBarcode());

        return product;
    }

    public ProductResponseDTO toResponse(Product product) {

        String categoryName = null;

        if (product.getCategory() != null) {
            categoryName = product.getCategory().getName();
        }

        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getInventoryQuantity(),
                product.getBarcode(),
                categoryName);
    }
}
