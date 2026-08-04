package com.cassiano.pontodevenda.dto.request;

import java.math.BigDecimal;

public class ProductRequestDTO {

    private String name;
    private BigDecimal price;
    private BigDecimal inventoryQuantity;
    private String barcode;
    private Integer categoryId;
    private String categoryName;

    public ProductRequestDTO() {
    }

    public ProductRequestDTO(
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

    public ProductRequestDTO(
            String name,
            BigDecimal price,
            BigDecimal inventoryQuantity,
            String barcode,
            String categoryName) {

        this.name = name;
        this.price = price;
        this.inventoryQuantity = inventoryQuantity;
        this.barcode = barcode;
        this.categoryName = categoryName;
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
