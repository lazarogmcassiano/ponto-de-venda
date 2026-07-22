package com.cassiano.pontodevenda.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoResponseDTO {

        private Long id;
        private String nome;
        private BigDecimal preco;
        private Integer estoque;
        private String codigo_barra;
        private String Categoria;
        
        
    public ProdutoResponseDTO(){

     }
   
    public ProdutoResponseDTO(Integer id, String nome, BigDecimal preco, Integer estoque, String codigo_barra, String Categoria){
    
    }
}
