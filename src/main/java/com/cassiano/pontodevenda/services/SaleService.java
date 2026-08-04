package com.cassiano.pontodevenda.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cassiano.pontodevenda.dto.request.SaleItemRequestDTO;
import com.cassiano.pontodevenda.dto.request.SaleRequestDTO;
import com.cassiano.pontodevenda.dto.response.SaleResponseDTO;
import com.cassiano.pontodevenda.entities.Product;
import com.cassiano.pontodevenda.entities.Sale;
import com.cassiano.pontodevenda.entities.SaleItem;
import com.cassiano.pontodevenda.mappers.SaleMapper;
import com.cassiano.pontodevenda.repositories.ProductRepository;
import com.cassiano.pontodevenda.repositories.SaleRepository;

@Service
@Transactional
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SaleMapper saleMapper;

    public SaleResponseDTO processSale(SaleRequestDTO saleRequest) {

        Sale sale = new Sale();
        sale.setDate(LocalDateTime.now());
        sale.setSaleItems(new ArrayList<>());

        BigDecimal total = BigDecimal.ZERO;

        for (SaleItemRequestDTO itemRequest : saleRequest.getSaleItems()) {

            Product product = productRepository.findById(itemRequest.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found."));

            if (product.getInventoryQuantity()
                    .compareTo(itemRequest.getQuantity()) < 0) {

                throw new RuntimeException(
                        "Insufficient inventory for product: " + product.getName());
            }

            SaleItem saleItem = new SaleItem();

            saleItem.setSale(sale);
            saleItem.setProduct(product);
            saleItem.setQuantity(itemRequest.getQuantity());
            saleItem.setUnitPrice(product.getPrice());

            BigDecimal subtotal = product.getPrice()
                    .multiply(itemRequest.getQuantity());

            saleItem.setSubtotal(subtotal);

            sale.getSaleItems().add(saleItem);

            total = total.add(subtotal);

            product.setInventoryQuantity(
                    product.getInventoryQuantity()
                            .subtract(itemRequest.getQuantity()));

            productRepository.save(product);
        }

        sale.setTotal(total);

        Sale savedSale = saleRepository.save(sale);

        return saleMapper.toResponse(savedSale);
    }

    public List<SaleResponseDTO> findAll() {

        return saleRepository.findAll()
                .stream()
                .map(saleMapper::toResponse)
                .toList();
    }

    public SaleResponseDTO findById(UUID id) {

        return saleRepository.findById(id)
                .map(saleMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Sale not found."));
    }

    public void delete(UUID id) {

        Sale sale = saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sale not found."));

        saleRepository.delete(sale);
    }

    public SaleResponseDTO update(UUID id, Sale updatedSale) {

        Sale sale = saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sale not found."));

        sale.setDate(updatedSale.getDate());
        sale.setTotal(updatedSale.getTotal());

        Sale savedSale = saleRepository.save(sale);

        return saleMapper.toResponse(savedSale);
    }
}
