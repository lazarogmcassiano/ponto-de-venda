package com.cassiano.pontodevenda.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cassiano.pontodevenda.dto.response.ItemVendaResponseDTO;
import com.cassiano.pontodevenda.dto.response.VendaResponseDTO;
import com.cassiano.pontodevenda.entities.Venda;

@Component
public class VendaMapper {

    private final ItemVendaMapper itemVendaMapper;

    public VendaMapper(ItemVendaMapper itemVendaMapper) {
        this.itemVendaMapper = itemVendaMapper;
    }

    public VendaResponseDTO toResponse(Venda venda) {

        List<ItemVendaResponseDTO> itens = venda.getItens()
                .stream()
                .map(itemVendaMapper::toResponse)
                .toList();

        return new VendaResponseDTO(
                venda.getId(),
                venda.getData(),
                venda.getTotal(),
                itens);
    }
}
