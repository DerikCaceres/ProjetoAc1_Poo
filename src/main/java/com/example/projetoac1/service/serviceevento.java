package com.example.projetoac1.service;


import java.time.LocalDate;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;


import com.example.projetoac1.Dto.Dtoevento;
import com.example.projetoac1.Dto.Dtoinsert;
import com.example.projetoac1.Dto.Dtoup;
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


    public Page<Dtoevento> getcliente(PageRequest pageRequest, String name,String local, LocalDate datainicio, String descricao){
        
        Page <evento> list = repository.find(pageRequest, name, local, datainicio, descricao );
        return list.map(event -> new Dtoevento(event));
    } 

    public Dtoevento getclientebyId(long id){

        Optional <evento> op = repository.findById(id);
        evento event = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Nao cadastrado no sistema."));

        return new Dtoevento(event);
    }

    public Dtoevento insert(Dtoinsert insertDto){

        evento entity = new evento(insertDto);
         entity = repository.save(entity);
         return new Dtoevento(entity);
    }
    public Dtoevento update(Long id, Dtoup updto){
        try{
            evento entity = repository.getOne(id);
            entity.setName(updto.getName());
            entity.setDescricao(updto.getDescricao());
            entity.setLocal(updto.getLocal());
            entity.setDatainicio(updto.getDatainicio());
            entity.setDatafinal(updto.getDatafinal());
            entity.setTempoinicio(updto.getTempoinicio());
            entity.setTempofinal(updto.getTempofinal());
            entity.setEmail(updto.getEmail());
            entity = repository.save(entity);
    
            return new Dtoevento(entity);
        }
        catch(EntityNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao cadastrado");
        }
    }

    public void apagarId(Long id){
        try{
            repository.deleteById(id);    
        }
        catch(EmptyResultDataAccessException e)  {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ID já apagado ou não encontrado");
        }
    }

    public Page<Dtoevento> getevento(PageRequest pageRequest, String name, String local,LocalDate datainicio, String descricao){
        Page<evento> list = repository.find(pageRequest,name,local,datainicio,descricao);
        return list.map(e -> new Dtoevento(e) );
    }

    public Dtoevento geteventobyId(long id) {
        Optional<evento> opcao = repository.findById(id);
        evento evento = opcao.orElseThrow( () ->  new ResponseStatusException(HttpStatus.NOT_FOUND, "evento nao encontrado"));
        return new Dtoevento(evento);
     
    }

    

    

   
    



}