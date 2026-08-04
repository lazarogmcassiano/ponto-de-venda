package com.cassiano.pontodevenda.dto.request;

import java.util.List;

public class SaleRequestDTO {

    private List<SaleItemRequestDTO> saleItems;

    public SaleRequestDTO() {
    }

    public SaleRequestDTO(List<SaleItemRequestDTO> saleItems) {
        this.saleItems = saleItems;
    }

    public List<SaleItemRequestDTO> getSaleItems() {
        return saleItems;
    }

    public void setSaleItems(List<SaleItemRequestDTO> saleItems) {
        this.saleItems = saleItems;
    }

}
