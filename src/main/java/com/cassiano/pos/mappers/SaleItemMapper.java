package com.cassiano.pos.mappers;

import org.springframework.stereotype.Component;

import com.cassiano.pos.dto.response.SaleItemResponseDTO;
import com.cassiano.pos.entities.SaleItem;

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
