package com.cassiano.pontodevenda.dto.request;

public class ItemVendaRequestDTO {

    private Long produtoId;
    private Integer quantidade;

    public ItemVendaRequestDTO() {

    }

    public ItemVendaRequestDTO(Long produtoId, Integer quantidade) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;

    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

}
