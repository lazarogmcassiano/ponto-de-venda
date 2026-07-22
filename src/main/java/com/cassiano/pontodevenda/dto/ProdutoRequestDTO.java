package com.cassiano.pontodevenda.dto;

import java.math.BigDecimal;

public class ProdutoRequestDTO {

    private String nome;
    private BigDecimal preco;
    private Integer estoque;
    private String codigoBarra;
    private Integer categoriaId;
    private String categoriaCodigo;

    public ProdutoRequestDTO (){
    }
     public ProdutoRequestDTO(String nome, BigDecimal preco, Integer estoque, String codigoBarra, Integer categoriaId){
    this.nome = nome;
    this.preco = preco;
    this.estoque = estoque;
    this.codigoBarra = codigoBarra;
    this.categoriaId = categoriaId;
    }

    public ProdutoRequestDTO(String nome, BigDecimal preco, Integer estoque, String codigoBarra, String categoriaCodigo){
    this.nome = nome;
    this.preco = preco;
    this.estoque = estoque;
    this.codigoBarra = codigoBarra;
    this.categoriaCodigo = categoriaCodigo;
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
    public Integer getCategoriaId() {
        return categoriaId;
    }
    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }
    public String getCategoriaCodigo() {
        return categoriaCodigo;
    }
    public void setCategoriaCodigo(String categoriaCodigo) {
        this.categoriaCodigo = categoriaCodigo;
    }


}

