package com.cassiano.pontodevenda.dto;

import java.math.BigDecimal;

public class ProdutoResponseDTO {

        private Long id;
        private String nome;
        private BigDecimal preco;
        private Integer estoque;
        private String codigoBarra;
        private String Categoria;
        
        
    public ProdutoResponseDTO(){

     }
   
    public ProdutoResponseDTO(Long id, String nome, BigDecimal preco, Integer estoque, String codigoBarra, String Categoria){
   this.id = id;
   this.nome = nome;
   this.estoque = estoque;
   this.preco = preco;
   this.codigoBarra = codigoBarra;
   this.Categoria = Categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

}
