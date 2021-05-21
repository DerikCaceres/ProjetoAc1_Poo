package com.example.projetoac1.repositorio;



import java.time.LocalDate;

import com.example.projetoac1.entities.Evento;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface Eventorepositorio extends JpaRepository<Evento, Long>{
    @Query("SELECT c FROM Evento c " + 
    "WHERE " +
    "LOWER(c.name)           LIKE   LOWER(CONCAT('%', :name, '%'))          AND " +
    "LOWER(c.local)          LIKE   LOWER(CONCAT('%', :local, '%'))         AND " +
    "LOWER(c.descricao)      LIKE   LOWER(CONCAT('%', :descricao, '%'))     AND " +
    "c.datainicio > :datainicio" 
)   

    public Page<Evento> find(Pageable pageRequest, String name, String local,LocalDate datainicio, String descricao);
  
}

