package com.example.projetoac1.repositorio;


import com.example.projetoac1.entities.TicketEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository <TicketEntity,Long>{
    
}

