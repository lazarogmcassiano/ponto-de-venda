package com.cassiano.pontodevenda.dto.request;

import java.math.BigDecimal;

public class SaleItemRequestDTO {

    private Long productId;
    private BigDecimal quantity;

    public SaleItemRequestDTO() {
    }

    public SaleItemRequestDTO(Long productId, BigDecimal quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

}
