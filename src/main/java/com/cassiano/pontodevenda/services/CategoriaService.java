package com.cassiano.pontodevenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cassiano.pontodevenda.dto.response.CategoriaResponseDTO;
import com.cassiano.pontodevenda.entities.Categoria;
import com.cassiano.pontodevenda.mappers.CategoriaMapper;
import com.cassiano.pontodevenda.repositories.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaResponseDTO salvar(String nome) {

        Categoria categoria = categoriaRepository.findByNome(nome)
                .orElseGet(() -> {
                    Categoria nova = new Categoria();
                    nova.setNome(nome);
                    return categoriaRepository.save(nova);
                });

        return categoriaMapper.toResponse(categoria);
    }

    public List<CategoriaResponseDTO> buscarTodos() {

        return categoriaRepository.findAll()
                .stream()
                .map(categoriaMapper::toResponse)
                .toList();

    }

    public Categoria BuscarPorId(Integer id) {
        if (id == null) {
            return categoriaRepository.findByNome("Outros")
                    .orElseThrow(() -> new RuntimeException("Id categoria vazio, adicionou na padrao."));
        }
        return categoriaRepository.findById(id)
                .orElseGet(() -> categoriaRepository.findByNome("Outros")
                        .orElseThrow(() -> new RuntimeException("Contate o suporte!")));
    }

    public Categoria buscarPorNome(String nome) {

        return categoriaRepository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Categoria nao encontrada"));
    }
}
