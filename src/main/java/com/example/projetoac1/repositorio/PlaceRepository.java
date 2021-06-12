package com.example.projetoac1.repositorio;

import com.example.projetoac1.entities.PlaceEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository <PlaceEntity,Long>{

        //isso é uma consulta JPQL!!!!!
    @Query("SELECT c FROM PlaceEntity c ")   
    
        public Page<PlaceEntity>find(PageRequest pageRequest,String name,String Address);


    
}