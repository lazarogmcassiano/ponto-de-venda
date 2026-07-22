package com.cassiano.pontodevenda.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Produto  {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
        private String nome;

        private BigDecimal  preco;

        private Integer estoque;

        @Column(name = "codigo_barra", unique = true)
        private String codigoBarra;
       
        @OneToMany(mappedBy = "produto") 
        private List<ItemVenda> itens = new ArrayList<>();

        @ManyToOne
        @JoinColumn(name = "categoria_id")
        private Categoria categoria;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public BigDecimal getPreco() {
            return preco;
        }

        public void setPreco(BigDecimal preco) {
            this.preco = preco;
        }

        public Integer getEstoque() {
            return estoque;
        }

        public void setEstoque(Integer estoque) {
            this.estoque = estoque;
        }

        public String getCodigoBarra() {
            return codigoBarra;
        }

        public void setCodigoBarra(String codigoBarra) {
            this.codigoBarra = codigoBarra;
        }

        public List<ItemVenda> getItens() {
            return itens;
        }

        public void setItens(List<ItemVenda> itens) {
            this.itens = itens;
        }

        public Categoria getCategoria() {
            return categoria;
        }

        public void setCategoria(Categoria categoria) {
            this.categoria = categoria;
        }



}
