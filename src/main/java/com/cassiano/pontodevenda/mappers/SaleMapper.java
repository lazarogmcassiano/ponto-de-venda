package com.cassiano.pontodevenda.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cassiano.pontodevenda.dto.response.SaleItemResponseDTO;
import com.cassiano.pontodevenda.dto.response.SaleResponseDTO;
import com.cassiano.pontodevenda.entities.Sale;

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
