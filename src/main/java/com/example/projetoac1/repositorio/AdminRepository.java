package com.example.projetoac1.repositorio;


import com.example.projetoac1.dtoAdm.AdminDto;
import com.example.projetoac1.entities.AdminEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;




@Repository
public interface AdminRepository extends JpaRepository <AdminEntity,Long>{

    @Query("SELECT c FROM AdminEntity c " )
    public Page<AdminDto>find(PageRequest pageRequest,String name,String phoneNumber,String email);
}


