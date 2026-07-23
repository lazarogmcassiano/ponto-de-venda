package com.cassiano.pontodevenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cassiano.pontodevenda.dto.request.ProdutoRequestDTO;
import com.cassiano.pontodevenda.dto.response.ProdutoResponseDTO;
import com.cassiano.pontodevenda.entities.Produto;
import com.cassiano.pontodevenda.mappers.ProdutoMapper;
import com.cassiano.pontodevenda.repositories.ProdutoRepository;

@Service
@Transactional
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ProdutoMapper mapper;

    public ProdutoResponseDTO salvar(ProdutoRequestDTO dto) {

        Produto produto = mapper.toEntity(dto);

        produto.setCategoria(
                categoriaService.BuscarPorId(dto.getCategoriaId()));

        Produto salvo = produtoRepository.save(produto);

        return mapper.toResponse(salvo);
    }

    public List<ProdutoResponseDTO> listarTodos() {
        return produtoRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO dto) {

        Produto produto = buscarPorId(id);

        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setEstoque(dto.getEstoque());
        produto.setCodigoBarra(dto.getCodigoBarra());

        produto.setCategoria(categoriaService.BuscarPorId(
                dto.getCategoriaId()));

        Produto atualizado = produtoRepository.save(produto);

        return mapper.toResponse(atualizado);
    }

    public void excluir(Long id) {

        Produto produto = buscarPorId(id);

        produtoRepository.delete(produto);
    }

    public Produto buscarPorNome(String nome) {
        return produtoRepository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado "));
    }

    public ProdutoResponseDTO buscarPorCodigo(String codigo) {

        Produto resposta = produtoRepository.findByCodigoBarra(codigo)
                .orElseThrow(() -> new RuntimeException("Produto nao encontrado"));
        return mapper.toResponse(resposta);

    }
}
