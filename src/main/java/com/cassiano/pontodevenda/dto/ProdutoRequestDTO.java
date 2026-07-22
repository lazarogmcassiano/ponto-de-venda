package com.cassiano.pontodevenda.dto;

import java.math.BigDecimal;

public class ProdutoRequestDTO {

    private String nome;
    private BigDecimal preco;
    private Integer estoque;
    private String codigo_barra;
    private Integer categoriaId;
    private String categoriaCodigo;

    public ProdutoRequestDTO (){
    }
     public ProdutoRequestDTO(String nome, BigDecimal preco, Integer estoque, String codigo_barra, Integer categoriaId){
    this.nome = nome;
    this.preco = preco;
    this.estoque = estoque;
    this.codigo_barra = codigo_barra;
    this.categoriaId = categoriaId;
    }

    public ProdutoRequestDTO(String nome, BigDecimal preco, Integer estoque, String codigo_barra, String categoriaCodigo){
    this.nome = nome;
    this.preco = preco;
    this.estoque = estoque;
    this.codigo_barra = codigo_barra;
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
    public String getCodigo_barra() {
        return codigo_barra;
    }
    public void setCodigo_barra(String codigo_barra) {
        this.codigo_barra = codigo_barra;
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
