package com.cassiano.pontodevenda.dto;

import java.math.BigDecimal;

public class ProdutoRequestDTO {

    private String nome;
    private BigDecimal preco;
    private Integer estoque;
    private String codigo_barra;

    public ProdutoRequestDTO (){
    }

    public ProdutoRequestDTO(String nome, BigDecimal preco, Integer estoque, String codigo_barra){
    
    }
}
