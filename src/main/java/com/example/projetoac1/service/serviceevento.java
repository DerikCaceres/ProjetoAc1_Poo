package com.example.projetoac1.service;


import java.time.LocalDate;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;


import com.example.projetoac1.Dto.DtoEvento;
import com.example.projetoac1.Dto.Dtoinsert;
import com.example.projetoac1.Dto.Dtoup;
import com.example.projetoac1.entities.Evento;
import com.example.projetoac1.repositorio.Eventorepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ServiceEvento {
    
    @Autowired
    private Eventorepositorio repository;


    public Page<DtoEvento> getEvento(PageRequest pageRequest,String name, String local,LocalDate datainicio, String descricao){
        
        Page <Evento> list = repository.find(pageRequest,name,local,datainicio,descricao);
        return list.map(e -> new DtoEvento(e));
    } 

    public DtoEvento getEventobyId(long id){

        Optional <Evento> op = repository.findById(id);
        Evento event = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Nao cadastrado no sistema."));

        return new DtoEvento(event);
    }

    public DtoEvento insert(Dtoinsert insertDto){

        Evento entity = new Evento(insertDto);
         entity = repository.save(entity);
         return new DtoEvento(entity);
    }
    public DtoEvento update(Long id, Dtoup updto){
        try{
            Evento entity = repository.getOne(id);
            entity.setName(updto.getName());
            entity.setDescricao(updto.getDescricao());
            entity.setLocal(updto.getLocal());
            entity.setDatainicio(updto.getDatainicio());
            entity.setDatafinal(updto.getDatafinal());
            entity.setTempoinicio(updto.getTempoinicio());
            entity.setTempofinal(updto.getTempofinal());
            entity.setEmail(updto.getEmail());
            entity = repository.save(entity);
    
            return new DtoEvento(entity);
        }
        catch(EntityNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evento nao cadastrado");
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
 
    

}