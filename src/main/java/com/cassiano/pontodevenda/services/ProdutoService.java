package com.cassiano.pontodevenda.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cassiano.pontodevenda.dto.ProdutoRequestDTO;
import com.cassiano.pontodevenda.entities.Categoria;
import com.cassiano.pontodevenda.entities.Produto;
import com.cassiano.pontodevenda.repositories.CategoriaRepository;
import com.cassiano.pontodevenda.repositories.ProdutoRepository;



@Service
@Transactional
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Produto salvar(ProdutoRequestDTO dto) {

        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setEstoque(dto.getEstoque());
        produto.setCodigoBarra(dto.getCodigoBarra());

        Categoria categoria;

        if (dto.getCategoriaId() == null) {

            categoria = categoriaRepository
                    .findByNome("Outros")
                    .orElseThrow(() ->
                            new RuntimeException("Categoria 'Outros' não encontrada"));

        } else {

            categoria = categoriaRepository
                    .findById(dto.getCategoriaId())
                    .orElseThrow(() ->
                            new RuntimeException("Categoria não encontrada"));

        }

        produto.setCategoria(categoria);

        return produtoRepository.save(produto);
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }
    
    public ProdutoService() {
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Produto não encontrado"));
    }

    public Produto atualizar(Long id, ProdutoRequestDTO dto) {

        Produto produto = buscarPorId(id);

        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setEstoque(dto.getEstoque());
        produto.setCodigoBarra(dto.getCodigoBarra());

        Categoria categoria;

        if (dto.getCategoriaId() == null) {

            categoria = categoriaRepository
                    .findByNome("Outros")
                    .orElseThrow(() ->
                            new RuntimeException("Categoria 'Outros' não encontrada"));

        } else {

            categoria = categoriaRepository
                    .findById(dto.getCategoriaId())
                    .orElseThrow(() ->
                            new RuntimeException("Categoria não encontrada"));
        }

        produto.setCategoria(categoria);

        return produtoRepository.save(produto);
    } 

    public void excluir(Long id) {

        Produto produto = buscarPorId(id);

        produtoRepository.delete(produto);
    }

    public Produto buscarPorNome(String nome) {
        return produtoRepository.findByNome(nome)
                 .orElseThrow(() -> 
                         new RuntimeException("Produto não encontrado "));
    }

    public Produto buscarPorCodigo(String codigo) {
        return produtoRepository.findByCodigoBarra(codigo)
                 .orElseThrow(() -> 
                         new RuntimeException("Codigo não encontrado "));
    }
}

