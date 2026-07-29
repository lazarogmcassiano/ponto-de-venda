package com.cassiano.pontodevenda.mappers;

import org.springframework.stereotype.Component;

import com.cassiano.pontodevenda.dto.response.ItemVendaResponseDTO;
import com.cassiano.pontodevenda.entities.ItemVenda;

@Component
public class ItemVendaMapper {

    public ItemVendaResponseDTO toResponse(ItemVenda item) {

        return new ItemVendaResponseDTO(
                item.getId(),
                item.getQuantidade(),
                item.getPrecoUnitario(),
                item.getSubtotal(),
                item.getProduto().getId(),
                item.getProduto().getNome());
    }
}
