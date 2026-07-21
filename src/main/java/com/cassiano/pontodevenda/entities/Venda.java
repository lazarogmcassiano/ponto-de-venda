package com.cassiano.pontodevenda.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

@Getter
@Setter
@Entity
public class Venda {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IDENITY;

    private LocalDateTime data;

    private BigDecimal total;
 
    @OneToMany(mappedBy = "venda")
    private List<ItemVenda> itens;

}
