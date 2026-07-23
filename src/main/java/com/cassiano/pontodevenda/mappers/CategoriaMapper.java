package com.cassiano.pontodevenda.mappers;

import com.cassiano.pontodevenda.dto.request.CategoriaRequestDTO;
import com.cassiano.pontodevenda.dto.response.CategoriaResponseDTO;
import com.cassiano.pontodevenda.entities.Categoria;

public class CategoriaMapper {

    public Categoria toEntity(CategoriaRequestDTO dto) {

        Categoria categoria = new Categoria();

        categoria.setNome(dto.getNome());

        return categoria;

    }

    public CategoriaResponseDTO toResponse(Categoria categoria) {

        return new CategoriaResponseDTO(
                categoria.getId(),
                categoria.getNome());
    }
}
