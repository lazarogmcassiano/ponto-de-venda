package com.cassiano.pos.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cassiano.pos.dto.response.SaleItemResponseDTO;
import com.cassiano.pos.dto.response.SaleResponseDTO;
import com.cassiano.pos.entities.Sale;

@Component
public class SaleMapper {

    private final SaleItemMapper saleItemMapper;

    public SaleMapper(SaleItemMapper saleItemMapper) {
        this.saleItemMapper = saleItemMapper;
    }

    public SaleResponseDTO toResponse(Sale sale) {

        List<SaleItemResponseDTO> saleItems = sale.getSaleItems()
                .stream()
                .map(saleItemMapper::toResponse)
                .toList();

        return new SaleResponseDTO(
                sale.getId(),
                sale.getDate(),
                sale.getTotal(),
                saleItems);
    }
}
