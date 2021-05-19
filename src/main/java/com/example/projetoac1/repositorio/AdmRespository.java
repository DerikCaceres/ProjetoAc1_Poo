package com.example.projetoac1.repositorio;

import com.example.projetoac1.dtoAdm.DtoAdm;
import com.example.projetoac1.entities.AdminEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;




@Repository
public interface AdmRespository extends JpaRepository <AdminEntity,Long>{
    @Query("SELECT c FROM EventsCadastro c " + 
    "WHERE " +
    "LOWER(c.nome)           LIKE   LOWER(CONCAT('%', :nome, '%'))          AND " +
    "LOWER(c.lugar)          LIKE   LOWER(CONCAT('%', :lugar, '%'))         AND " +
    "LOWER(c.descricao)      LIKE   LOWER(CONCAT('%', :descricao, '%'))" 
)   

    public Page<DtoAdm>find(PageRequest pageRequest,String name,String telefone,String email);
}


