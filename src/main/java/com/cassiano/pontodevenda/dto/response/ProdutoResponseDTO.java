package com.cassiano.pontodevenda.dto.response;

import java.math.BigDecimal;

public class ProdutoResponseDTO {

    private Long id;
    private String nome;
    private BigDecimal preco;
    private Integer estoque;
    private String codigoBarra;
    private Integer categoriaId;
    private String categoriaNome;

    public ProdutoResponseDTO() {
    }

    public ProdutoResponseDTO(String nome, BigDecimal preco, Integer estoque, String codigoBarra, Integer categoriaId) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.codigoBarra = codigoBarra;
        this.categoriaId = categoriaId;
    }

    public ProdutoResponseDTO(Long id, String nome, BigDecimal preco, Integer estoque, String codigoBarra,
            String categoriaNome) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.codigoBarra = codigoBarra;
        this.categoriaNome = categoriaNome;
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
