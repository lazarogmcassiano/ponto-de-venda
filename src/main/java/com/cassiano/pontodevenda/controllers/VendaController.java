package com.cassiano.pontodevenda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cassiano.pontodevenda.dto.request.VendaRequestDTO;
import com.cassiano.pontodevenda.dto.response.VendaResponseDTO;
import com.cassiano.pontodevenda.services.VendaService;

@RestController
@RequestMapping("/vendas")
@CrossOrigin("*")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping
    public ResponseEntity<VendaResponseDTO> realizarVenda(@RequestBody VendaRequestDTO vendaDTO) {

        VendaResponseDTO venda = vendaService.realizarVenda(vendaDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(venda);
    }

    @GetMapping
    public ResponseEntity<List<VendaResponseDTO>> listar() {
        return ResponseEntity.ok(vendaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(vendaService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        vendaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
