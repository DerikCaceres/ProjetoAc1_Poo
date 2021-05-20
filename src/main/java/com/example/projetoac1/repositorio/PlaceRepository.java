package com.example.projetoac1.repositorio;

import com.example.projetoac1.entities.PlaceEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository <PlaceEntity,Long>{
    
}