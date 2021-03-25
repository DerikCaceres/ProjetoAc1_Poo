package com.example.projetoac1.repositorio;



import com.example.projetoac1.entities.cliente;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface clienterepositorio extends JpaRepository<cliente, Long>{
    @Query("SELECT c FROM cliente " )

    public Page<cliente>find(Pageable pageResquest,String name);
  
}

