package com.example.projetoac1.repositorio;

import com.example.projetoac1.entities.AdminEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface AdmRepository extends JpaRepository <AdminEntity,Long>{

}


