package com.cassiano.pontodevenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cassiano.pontodevenda.dto.request.CategoriaRequestDTO;
import com.cassiano.pontodevenda.dto.response.CategoriaResponseDTO;
import com.cassiano.pontodevenda.entities.Categoria;
import com.cassiano.pontodevenda.mappers.CategoriaMapper;
import com.cassiano.pontodevenda.repositories.CategoriaRepository;

@Transactional
@Service
public class CategoriaService {

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaResponseDTO salvar(CategoriaRequestDTO dto) {

        Categoria categoria = categoriaRepository.findByNome(dto.getNome())
                .orElseGet(() -> {

                    Categoria nova = new Categoria();
                    nova.setNome(dto.getNome());

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

    public Categoria buscarPorId(Integer id) {

        if (id == null) {
            return buscarCategoriaPadrao();
        }

        return categoriaRepository.findById(id)
                .orElseGet(this::buscarCategoriaPadrao);
    }

    private Categoria buscarCategoriaPadrao() {

        return categoriaRepository.findByNome("Outros")
                .orElseThrow(() -> new RuntimeException(
                        "Categoria padrão 'Outros' não cadastrada."));
    }

    public Categoria buscarPorNome(String nome) {

        return categoriaRepository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException(
                        "Categoria não encontrada."));
    }
}
