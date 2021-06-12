package com.example.projetoac1.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.example.projetoac1.dtoAdm.AdminDto;
import com.example.projetoac1.dtoAdm.AdminDtoInsert;
import com.example.projetoac1.dtoAdm.AdminDtoUp;
import com.example.projetoac1.entities.AdminEntity;
import com.example.projetoac1.repositorio.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AdminService {
    //fazer o getAdmiByCodigo  feito|| getalladmin esta paginado  feito|| insert admin feito||apagar admin  feito||atualizar admin feito|| salvar admin



    @Autowired
    private AdminRepository repository;

        public Page<AdminDto> getAdmin(PageRequest pageRequest,String name,String phoneNumber,String email){
        
        Page <AdminDto> list = repository.find(pageRequest,name,phoneNumber,email);
        return list.map(adm -> new AdminDto(adm));
    } 

    
    public AdminDto getAdminById(long id) {

        Optional <AdminEntity> op = repository.findById(id);
        AdminEntity admin = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado no sistema!!!"));

        return new AdminDto(admin);
    }

    
    public AdminDto insert(AdminDtoInsert insertDto){

        AdminEntity entity = new AdminEntity(insertDto);
        entity = repository.save(entity);
        return new AdminDto(entity);
   }



    public void Remove(Long id){
        try{
            repository.deleteById(id);    
        }
        catch(EmptyResultDataAccessException e)  {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ID já apagado ou não encontrado");
        }
    }


    public AdminDto atualizar(long id, AdminDtoUp AdminDtoUp){

        try{
            AdminEntity admin = repository.getOne(id);
            admin.setName(AdminDtoUp.getName());
            admin.setEmail(AdminDtoUp.getEmail());
            admin.setPhoneNumber(AdminDtoUp.getPhoneNumber());
            admin = repository.save(admin);
            return new AdminDto(admin);
        }catch(EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ID não encontrado no Sistema!!!");
        }
    }


    // salvar admin tem que fazer ainda
 

}