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
    @Query("SELECT e FROM Evento e " + 
    " WHERE " + 
    "e.name like concat('%',:name,'%') and " +
    "e.local like concat('%',:local,'%') and " + 
    "e.descricao like concat('%',:descricao,'%') and e.datainicio > :datainicio")


    public Page<Evento> find(Pageable pageRequest, String name, String local,LocalDate datainicio, String descricao);
  
}

