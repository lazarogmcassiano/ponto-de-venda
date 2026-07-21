package com.cassiano.pontodevenda.entities;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

@Entity
@Getter
@Setter
public class Produto  {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
        private String nome;

        private BigDecimal  preco;

        private Integer estoque;

        private Integer codigo_barra;
       
        @OneToMany(mappedBy = "produto") 
        private List<ItemVenda> itens;

        @ManyToOne
        @JoinColumn(name = "categoria_id")
        private Categoria categoria;
}
