package com.example.projetoac1.repositorio;


import com.example.projetoac1.entities.AttendessEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendessRepository extends JpaRepository <AttendessEntity,Long>{

    @Query("SELECT e FROM EventsCadastro e ")
    Page<AttendessEntity> find(PageRequest pageRequest, String name, String email);

}