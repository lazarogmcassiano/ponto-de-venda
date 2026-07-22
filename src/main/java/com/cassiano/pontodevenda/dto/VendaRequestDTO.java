package com.cassiano.pontodevenda.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendaRequestDTO {

    private List<ItemVendaRequestDTO> itens;
}
