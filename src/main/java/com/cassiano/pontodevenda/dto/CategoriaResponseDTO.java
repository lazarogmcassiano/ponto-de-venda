package com.cassiano.pontodevenda.dto;

public class CategoriaResponseDTO {

    private Integer id;
    private String nome;

    public CategoriaResponseDTO(){
    }
    public CategoriaResponseDTO(Integer id, String nome){
            this.id = id;
            this.nome = nome;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }


}
