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
    @Query("SELECT e FROM Event e " + " WHERE " + "e.name like concat('%',:name,'%') and " + "e.lugar like concat('%',:lugar,'%') and " + "e.descricao like concat('%',:descricao,'%') and e.startDate > :startDate")

    public Page<evento> find(Pageable pageRequest, String name, String local,LocalDate datainicio, String descricao);
  
}

