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
    "LOWER(c.place)          LIKE   LOWER(CONCAT('%', :place, '%'))         AND " +
    "LOWER(c.description)      LIKE   LOWER(CONCAT('%', :description, '%'))     AND " +
    "c.startdate > :startdate" 
)   

    public Page<Evento> find(Pageable pageRequest, String name, String place,LocalDate startdate, String description);
  
}

