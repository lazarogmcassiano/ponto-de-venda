package com.cassiano.pontodevenda.mappers;

import org.springframework.stereotype.Component;

import com.cassiano.pontodevenda.dto.request.ProdutoRequestDTO;
import com.cassiano.pontodevenda.dto.response.ProdutoResponseDTO;
import com.cassiano.pontodevenda.entities.Produto;

@Component
public class ProdutoMapper {

    public Produto toEntity(ProdutoRequestDTO dto) {

        Produto produto = new Produto();

        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setEstoque(dto.getEstoque());
        produto.setCodigoBarra(dto.getCodigoBarra());

        return produto;
    }

    public ProdutoResponseDTO toResponse(Produto produto) {

        return new ProdutoResponseDTO(
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getEstoque(),
                produto.getCodigoBarra(),
                produto.getCategoria().getNome());
    }
}
