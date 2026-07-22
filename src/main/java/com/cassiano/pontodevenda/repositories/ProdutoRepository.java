package com.cassiano.pontodevenda.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cassiano.pontodevenda.entities.*;

public interface ProdutoRepository extends JpaRepository<Produto, Long>  {

    Optional<Produto> findByNome(String nome);
   
    Optional<Produto> findByCodigoBarra(String codigoBarra);
    
}
