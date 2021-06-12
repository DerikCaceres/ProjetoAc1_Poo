package com.example.projetoac1.repositorio;



import java.time.LocalDate;


import com.example.projetoac1.entities.EventsCadastro;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository <EventsCadastro,Long>{

    //isso é uma consulta JPQL!!!!!
    @Query("SELECT c FROM EventsCadastro c " + 
    "WHERE " +
    "LOWER(c.name)           LIKE   LOWER(CONCAT('%', :name, '%'))          AND " +
    "LOWER(c.place)          LIKE   LOWER(CONCAT('%', :place, '%'))         AND " +
    "LOWER(c.description)      LIKE   LOWER(CONCAT('%', :description, '%'))     AND " +
    "c.startDate > :startDate" 
)   

    public Page<EventsCadastro>find(Pageable pageResquest,String name,String place,String description,LocalDate startDate);
}