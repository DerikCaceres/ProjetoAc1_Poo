package com.example.projetoac1.service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;



import com.example.projetoac1.Dto.EventDto;
import com.example.projetoac1.Dto.EventDtoInsert;

import com.example.projetoac1.entities.EventsCadastro;
import com.example.projetoac1.entities.PlaceEntity;
import com.example.projetoac1.repositorio.EventRepository;
import com.example.projetoac1.repositorio.PlaceRepository;

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
    private PlaceService placeservice;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private EventRepository repository;

        public Page<EventDto> getClienteCadastro(PageRequest pageRequest,String name, String description,LocalDate startDate){
        
        Page <EventsCadastro> list = repository.find(pageRequest,name,description,startDate);
        return list.map(c -> new EventDto(c));
    } 

    public EventDto getClienteById(long id){

        Optional <EventsCadastro> op = repository.findById(id);
        EventsCadastro client = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Evento não encontrado no sistema!!!"));

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

    public EventDto placeevent(Long idevent, Long idplace) {
        getClienteById(idevent);
        EventsCadastro event = repository.getOne(idevent);

        placeservice.getPlaceById(idplace);
        PlaceEntity place = placeRepository.getOne(idplace);

        VerficationAvailability(event, place);

        event.addPlace(place);
        event = repository.save(event);

        return new EventDto(event);

    }
    private void VerficationAvailability(EventsCadastro event, PlaceEntity place) {

        List<EventsCadastro> events = repository.findAll();
        List<EventsCadastro> eventsAux = new ArrayList<>();

        for (EventsCadastro e : events) {
            if(e.getPlacebyId(place.getId()) ) {
                eventsAux.add(e);
            }
        }
        
        for (EventsCadastro eventcadastro : eventsAux) {
            dateverify(eventcadastro, event);   
        }
    }

    private boolean dateverify(EventsCadastro eventcadastro, EventsCadastro event) {
        if ( 
            (event.getEndDate().isAfter(eventcadastro.getStartDate())    && event.getEndDate().isBefore(eventcadastro.getEndDate()))   ||
            (event.getStartDate().isAfter(eventcadastro.getStartDate())  && event.getStartDate().isBefore(eventcadastro.getEndDate())) || 
            (event.getStartDate().isBefore(eventcadastro.getStartDate()) && event.getEndDate().isAfter(eventcadastro.getEndDate()))    ||
             event.getStartDate().equals(eventcadastro.getEndDate())     || event.getStartTime().isBefore(eventcadastro.getEndTime())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Data indisponivel para esse local");

            }
                

        if(event.getEndDate().equals(eventcadastro.getStartDate())) {
            if(event.getEndTime().isAfter(eventcadastro.getStartTime())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Data indisponivel para esse local");
            } 
        }

        return true;
   
    }


    
}