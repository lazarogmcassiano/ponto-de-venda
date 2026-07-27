package com.cassiano.pontodevenda.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cassiano.pontodevenda.dto.request.ItemVendaRequestDTO;
import com.cassiano.pontodevenda.dto.request.VendaRequestDTO;
import com.cassiano.pontodevenda.entities.ItemVenda;
import com.cassiano.pontodevenda.entities.Produto;
import com.cassiano.pontodevenda.entities.Venda;
import com.cassiano.pontodevenda.repositories.ProdutoRepository;
import com.cassiano.pontodevenda.repositories.VendaRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Venda realizarVenda(VendaRequestDTO vendaDTO) {

        Venda venda = new Venda();
        venda.setData(LocalDateTime.now());
        venda.setItens(new ArrayList<>());

        BigDecimal total = BigDecimal.ZERO;

        for (ItemVendaRequestDTO itemDTO : vendaDTO.getItens()) {

            Produto produto = produtoRepository.findById(itemDTO.getProdutoId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado."));

            if (produto.getEstoque() < itemDTO.getQuantidade()) {
                throw new RuntimeException(
                        "Estoque insuficiente para o produto: " + produto.getNome());
            }

            ItemVenda item = new ItemVenda();
            item.setVenda(venda);
            item.setProduto(produto);
            item.setQuantidade(itemDTO.getQuantidade());
            item.setPrecoUnitario(produto.getPreco());

            BigDecimal subtotal = produto.getPreco()
                    .multiply(BigDecimal.valueOf(itemDTO.getQuantidade()));

            item.setSubtotal(subtotal);

            venda.getItens().add(item);

            total = total.add(subtotal);

            // Atualiza o estoque
            produto.setEstoque(produto.getEstoque() - itemDTO.getQuantidade());
            produtoRepository.save(produto);
        }

        venda.setTotal(total);

        return vendaRepository.save(venda);
    }

    public List<Venda> listarTodas() {
        return vendaRepository.findAll();
    }

    public Venda buscarPorId(Long id) {
        return vendaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada."));
    }

    public void excluir(Long id) {
        Venda venda = buscarPorId(id);
        vendaRepository.delete(venda);
    }

    public Venda atualizar(Long id, Venda vendaAtualizada) {

        Venda venda = buscarPorId(id);

        venda.setData(vendaAtualizada.getData());
        venda.setTotal(vendaAtualizada.getTotal());

        return vendaRepository.save(venda);
    }
}
