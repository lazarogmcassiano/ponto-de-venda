package com.cassiano.pontodevenda.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemVendaRequestDTO {

    private Long produtoId;
    private Integer quantidade;

    public ItemVendaRequestDTO(){
   
    }

    public ItemVendaRequestDTO(Long produtoId, Integer quantidade){
        
    }
}
