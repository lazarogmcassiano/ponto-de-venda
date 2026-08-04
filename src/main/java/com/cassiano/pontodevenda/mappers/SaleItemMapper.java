package com.cassiano.pontodevenda.mappers;

import org.springframework.stereotype.Component;

import com.cassiano.pontodevenda.dto.response.SaleItemResponseDTO;
import com.cassiano.pontodevenda.entities.SaleItem;

@Component
public class SaleItemMapper {

    public SaleItemResponseDTO toResponse(SaleItem item) {

        return new SaleItemResponseDTO(
                item.getId(),
                item.getQuantity(),
                item.getUnitPrice(),
                item.getSubtotal(),
                item.getProduct().getId(),
                item.getProduct().getName());
    }
}
