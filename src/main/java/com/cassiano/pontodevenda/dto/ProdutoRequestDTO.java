package com.cassiano.pontodevenda.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoRequestDTO {

    private String nome;
    private BigDecimal preco;
    private Integer estoque;
    private String codigo_barra;
    private Integer categoriaId;
    public ProdutoRequestDTO (){
    }

    public ProdutoRequestDTO(String nome, BigDecimal preco, Integer estoque, String codigo_barra){
    
    }
}
