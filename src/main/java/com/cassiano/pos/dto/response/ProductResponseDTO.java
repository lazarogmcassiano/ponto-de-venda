package com.cassiano.pos.dto.response;

import java.math.BigDecimal;

public class ProductResponseDTO {

    private Long id;
    private String name;
    private BigDecimal price;
    private BigDecimal inventoryQuantity;
    private String barcode;
    private Integer categoryId;
    private String categoryName;

    public ProductResponseDTO() {
    }

    public ProductResponseDTO(
            String name,
            BigDecimal price,
            BigDecimal inventoryQuantity,
            String barcode,
            Integer categoryId) {

        this.name = name;
        this.price = price;
        this.inventoryQuantity = inventoryQuantity;
        this.barcode = barcode;
        this.categoryId = categoryId;
    }

    public ProductResponseDTO(
            Long id,
            String name,
            BigDecimal price,
            BigDecimal inventoryQuantity,
            String barcode,
            String categoryName) {

        this.id = id;
        this.name = name;
        this.price = price;
        this.inventoryQuantity = inventoryQuantity;
        this.barcode = barcode;
        this.categoryName = categoryName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(BigDecimal inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
