package com.cassiano.pontodevenda.dto.request;

import java.util.List;

public class VendaRequestDTO {

    private List<ItemVendaRequestDTO> itens;

    public VendaRequestDTO() {
    }

    public VendaRequestDTO(List<VendaRequestDTO> itens) {

    }

    public List<ItemVendaRequestDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemVendaRequestDTO> itens) {
        this.itens = itens;
    }

}
