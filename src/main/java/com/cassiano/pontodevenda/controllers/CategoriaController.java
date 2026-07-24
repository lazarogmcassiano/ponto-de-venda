package com.cassiano.pontodevenda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cassiano.pontodevenda.dto.request.CategoriaRequestDTO;
import com.cassiano.pontodevenda.dto.response.CategoriaResponseDTO;
import com.cassiano.pontodevenda.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
@CrossOrigin("*")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping()
    public ResponseEntity<CategoriaResponseDTO> criarCategoria(@RequestBody CategoriaRequestDTO dto) {

        return ResponseEntity.ok(categoriaService.salvar(dto));

    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> buscarCategoria() {
        return ResponseEntity.ok(categoriaService.buscarTodos());
    }

}
