package com.example.projetoac1.repositorio;



import java.time.LocalDate;

import com.example.projetoac1.entities.evento;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface eventorepositorio extends JpaRepository<evento, Long>{
    @Query("SELECT c FROM cliente " )

    public Page<evento>find(Pageable pageResquest,String name,String local, LocalDate datainicio, String descricao);
  
}

