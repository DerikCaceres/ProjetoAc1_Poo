package com.example.projetoac1.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;


import com.example.projetoac1.dtoAdm.DtoAdm;
import com.example.projetoac1.dtoAdm.DtoAdmInsert;
import com.example.projetoac1.entities.AdminEntity;
import com.example.projetoac1.repositorio.AdmRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AdmService {
   

    private AdmRepository repositoryAdmin;


    @Autowired
    private AdmRepository repository;

        public Page<DtoAdm> getAdmin(PageRequest pageRequest,String name,String telefone,String email){
        
        Page <DtoAdm> list = repositoryAdmin.find(pageRequest,name,telefone,email);
        return list.map(c -> new DtoAdm(c));
    } 

    
    public DtoAdm getAdminByCodigo(long id) {

        Optional <AdminEntity> op = repositoryAdmin.findById(id);
        AdminEntity adm = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado no sistema!!!"));

        return new DtoAdm(adm);
    }

    
    public DtoAdm insert(DtoAdmInsert insertDto){

        AdminEntity entity = new AdminEntity(insertDto);
        entity = repository.save(entity);
        return new DtoAdm(entity);
   }



    public void Remove(Long id){
        try{
            repository.deleteById(id);    
        }
        catch(EmptyResultDataAccessException e)  {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ID já apagado ou não encontrado");
        }
    }


    public DtoAdm atualizar(long id, DtoAdm AdminDtoUp){

        try{
            AdminEntity admin = repositoryAdmin.getOne(id);
            admin.setName(AdminDtoUp.getName());
            admin = repositoryAdmin.save(admin);
            return new DtoAdm(admin);
        }catch(EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ID não encontrado no Sistema!!!");
        }
    }



}
