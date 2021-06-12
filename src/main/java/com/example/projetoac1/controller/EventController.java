package com.example.projetoac1.controller;

import java.net.URI;
import java.time.LocalDate;

import com.example.projetoac1.Dto.EventDto;
import com.example.projetoac1.Dto.EventDtoInsert;
import com.example.projetoac1.service.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping("/events")
public class EventController {


    @Autowired
    private EventService service;

    @GetMapping
    public ResponseEntity<Page<EventDto>>getclients(

        @RequestParam(value = "page",         defaultValue = "0") Integer page,//?page=1
        @RequestParam(value = "linesPerPage", defaultValue = "6") Integer linesPerPage,//?page=1&perpage=4
        @RequestParam(value = "direction",    defaultValue = "ASC") String direction,//
        @RequestParam(value = "orderBy",      defaultValue = "id") String orderBy,//
        @RequestParam(value = "name",         defaultValue = "") String name,
        @RequestParam(value = "place",      defaultValue = "") String place,
        @RequestParam(value = "description",      defaultValue = "") String description,
        @RequestParam(value = "startDate",      defaultValue = "24/06/2000") LocalDate startDate
        
    ){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);

        Page <EventDto> list = service.getClienteCadastro(pageRequest,name,place,description,startDate);

        return ResponseEntity.ok().body(list);      
    }

    @GetMapping("{id}")
    public ResponseEntity<EventDto>getClienteById(@PathVariable long id){
        EventDto dto = service.getClienteById(id);
        return ResponseEntity.ok().body(dto);      
    }
    @PostMapping
    public ResponseEntity<EventDto> insert(@RequestBody EventDtoInsert insertDto){
        EventDto dto = service.insert(insertDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> apagarById(@PathVariable Long id){
        service.apagarId(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<EventDto> update(@RequestBody EventDto updateDto, @PathVariable Long id){
        EventDto dto = service.atualizar(id,updateDto);
        return ResponseEntity.ok().body(dto);
    }
                                                                                
}
