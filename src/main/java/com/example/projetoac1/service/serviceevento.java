package com.example.projetoac1.service;


import java.util.Optional;

import javax.persistence.EntityNotFoundException;


import com.example.projetoac1.Dto.Dtoevento;
import com.example.projetoac1.Dto.Dtoinsert;
import com.example.projetoac1.entities.evento;
import com.example.projetoac1.repositorio.eventorepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class serviceevento {
    
    @Autowired
    private eventorepositorio repository;


    public Page<Dtoevento> getcliente(PageRequest pageRequest, String nome){
        
        Page <evento> list = repository.find(pageRequest, nome );
        return list.map(c -> new Dtoevento(c));
    } 

    public Dtoevento getclientebyId(long id){

        Optional <evento> op = repository.findById(id);
        evento client = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Nao cadastrado no sistema."));

        return new Dtoevento(client);
    }

    public Dtoevento insert(Dtoinsert insertDto){

        evento entity = new evento(insertDto);
         entity = repository.save(entity);
         return new Dtoevento(entity);
    }

    public void apagarId(Long id){
        try{
            repository.deleteById(id);    
        }
        catch(EmptyResultDataAccessException e)  {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ID já apagado ou não encontrado");
        }
    }

    public Dtoevento atualizar(long id, Dtoevento updateDto){

        try{
            evento entity = repository.getOne(id);
            entity.setName(updateDto.getName());
            entity=repository.save(entity);
            return new Dtoevento(entity);
        }catch(EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ID não encontrado no Sistema!!!");
        }
    }
    



}