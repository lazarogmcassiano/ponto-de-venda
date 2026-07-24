package com.cassiano.pontodevenda.dto.request;

import java.math.BigDecimal;

public class ProdutoRequestDTO {

    private String nome;
    private BigDecimal preco;
    private Integer estoque;
    private String codigoBarra;
    private Integer categoriaId;
    private String categoriaNome;

    public ProdutoRequestDTO() {
    }

    public ProdutoRequestDTO(String nome, BigDecimal preco, Integer estoque, String codigoBarra, Integer categoriaId) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.codigoBarra = codigoBarra;
        this.categoriaId = categoriaId;
    }

    public ProdutoRequestDTO(String nome, BigDecimal preco, Integer estoque, String codigoBarra,
            String categoriaNome) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.codigoBarra = codigoBarra;
        this.categoriaNome = categoriaNome;
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

    public String getCategoriaNome() {
        return categoriaNome;
    }

    public void setCategoriaNome(String categoriaNome) {
        this.categoriaNome = categoriaNome;
    }

}
