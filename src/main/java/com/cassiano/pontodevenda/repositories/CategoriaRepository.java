package com.cassiano.pontodevenda.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cassiano.pontodevenda.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>  {

        Optional<Categoria> findByNome(String nome);


}
