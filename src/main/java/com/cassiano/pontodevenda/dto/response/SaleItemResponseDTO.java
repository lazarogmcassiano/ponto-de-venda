package com.cassiano.pontodevenda.dto.response;

import java.math.BigDecimal;

public class SaleItemResponseDTO {

    private Long id;
    private BigDecimal quantity;
    private BigDecimal unitPrice;
    private BigDecimal subtotal;
    private Long productId;
    private String productName;

    public SaleItemResponseDTO() {
    }

    public SaleItemResponseDTO(
            Long id,
            BigDecimal quantity,
            BigDecimal unitPrice,
            BigDecimal subtotal,
            Long productId,
            String productName) {

        this.id = id;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subtotal = subtotal;
        this.productId = productId;
        this.productName = productName;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }
}
