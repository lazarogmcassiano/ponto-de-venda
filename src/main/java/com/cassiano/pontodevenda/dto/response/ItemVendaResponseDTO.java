package com.cassiano.pontodevenda.dto.response;

import java.math.BigDecimal;

public class ItemVendaResponseDTO {

    private Long id;
    private Integer quantidade;
    private BigDecimal precoUnitario;
    private BigDecimal subtotal;
    private Long produtoId;
    private String produtoNome;

    public ItemVendaResponseDTO(
            Long id,
            Integer quantidade,
            BigDecimal precoUnitario,
            BigDecimal subtotal,
            Long produtoId,
            String produtoNome) {
        this.id = id;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.subtotal = subtotal;
        this.produtoId = produtoId;
        this.produtoNome = produtoNome;
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public String getProdutoNome() {
        return produtoNome;
    }
}
