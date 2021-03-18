package com.example.projetoac1.repositorio;



import com.example.projetoac1.entities.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface clienterepositorio extends JpaRepository<cliente, Long>{
  
}

