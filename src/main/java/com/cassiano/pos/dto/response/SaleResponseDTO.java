package com.cassiano.pos.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class SaleResponseDTO {

    private UUID id;
    private LocalDateTime date;
    private BigDecimal total;
    private List<SaleItemResponseDTO> saleItems;

    public SaleResponseDTO(
            UUID id,
            LocalDateTime date,
            BigDecimal total,
            List<SaleItemResponseDTO> saleItems) {

        this.id = id;
        this.date = date;
        this.total = total;
        this.saleItems = saleItems;
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public List<SaleItemResponseDTO> getSaleItems() {
        return saleItems;
    }
}
