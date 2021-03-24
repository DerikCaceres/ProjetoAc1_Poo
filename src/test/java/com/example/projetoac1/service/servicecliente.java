package com.example.projetoac1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.example.projetoac1.Dto.Dtocliente;
import com.example.projetoac1.Dto.Dtoinsert;
import com.example.projetoac1.entities.cliente;
import com.example.projetoac1.repositorio.clienterepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class servicecliente {
    
    @Autowired
    private clienterepositorio repository;


    public List<Dtocliente> getClienteCadastro(){
        
        List <cliente> list = repository.findAll();
        return toDTOlist(list);
    } 

    public Dtocliente getClienteById(long id){

        Optional <cliente> op = repository.findById(id);
        cliente client = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Nao cadastrado no sistema."));

        return new Dtocliente(client);
    }

    public Dtocliente insert(Dtoinsert insertDto){

        cliente entity = new cliente(insertDto);
         entity = repository.save(entity);
         return new Dtocliente(entity);
    }

    public void apagarId(Long id){
        try{
            repository.deleteById(id);    
        }
        catch(EmptyResultDataAccessException e)  {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ID já apagado ou não encontrado");
        }
    }

    public Dtocliente atualizar(long id, Dtocliente updateDto){

        try{
            cliente entity = repository.getOne(id);
            entity.setName(updateDto.getnome());
            entity=repository.save(entity);
            return new Dtocliente(entity);
        }catch(EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ID não encontrado no Sistema!!!");
        }
    }
    

    private List<Dtocliente> toDTOlist(List<cliente>list){
        List<Dtocliente> listDto = new ArrayList<>();

        for(cliente c : list){
            listDto.add(new Dtocliente(c.getId(),c.getName()));
        }


        return listDto;
    }

}