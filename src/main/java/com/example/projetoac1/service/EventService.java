package com.example.projetoac1.service;


import java.time.LocalDate;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;



import com.example.projetoac1.Dto.EventDto;
import com.example.projetoac1.Dto.EventDtoInsert;

import com.example.projetoac1.entities.EventsCadastro;
import com.example.projetoac1.repositorio.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EventService {


    @Autowired
    private EventRepository repository;

        public Page<EventDto> getClienteCadastro(PageRequest pageRequest,String name, String place, String description,LocalDate startDate){
        
        Page <EventsCadastro> list = repository.find(pageRequest,name,place,description,startDate);
        return list.map(c -> new EventDto(c));
    } 

    public EventDto getClienteById(long id){

        Optional <EventsCadastro> op = repository.findById(id);
        EventsCadastro client = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado no sistema!!!"));

        return new EventDto(client);
    }   

    public EventDto insert(EventDtoInsert insertDto){

         EventsCadastro entity = new EventsCadastro(insertDto);
         entity = repository.save(entity);
         return new EventDto(entity);
    }

    public void apagarId(Long id){
        try{
            repository.deleteById(id);    
        }
        catch(EmptyResultDataAccessException e)  {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ID já apagado ou não encontrado");
        }
    }

    public EventDto atualizar(long id, EventDto updateDto){

        try{
            EventsCadastro entity = repository.getOne(id);
            entity.setName(updateDto.getName());
            entity=repository.save(entity);
            return new EventDto(entity);
        }catch(EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ID não encontrado no Sistema!!!");
        }
    }
}