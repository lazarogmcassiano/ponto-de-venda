package com.cassiano.pontodevenda.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class VendaResponseDTO {

    private Long id;
    private LocalDateTime data;
    private BigDecimal total;
    private List<ItemVendaResponseDTO> itens;

    public VendaResponseDTO(
            Long id,
            LocalDateTime data,
            BigDecimal total,
            List<ItemVendaResponseDTO> itens) {
        this.id = id;
        this.data = data;
        this.total = total;
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public List<ItemVendaResponseDTO> getItens() {
        return itens;
    }
}
