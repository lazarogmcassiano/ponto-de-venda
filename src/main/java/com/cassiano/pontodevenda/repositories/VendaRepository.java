package com.cassiano.pontodevenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cassiano.pontodevenda.entities.*;

public interface VendaRepository extends JpaRepository<Venda, Long>  {


}
