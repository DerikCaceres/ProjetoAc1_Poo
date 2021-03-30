package com.example.projetoac1.controller;

import java.net.URI;


import com.example.projetoac1.Dto.Dtoevento;
import com.example.projetoac1.Dto.Dtoinsert;
import com.example.projetoac1.service.serviceevento;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
@RequestMapping("/evento")
public class eventocontroller 
{

    @Autowired
    private serviceevento srvc;

    @GetMapping
    public ResponseEntity<Page<Dtoevento>> getcliente(
    
    @RequestParam(value = "page",         defaultValue = "0") Integer page,
    @RequestParam(value = "linesPerPage", defaultValue = "6") Integer linesPerPage,
    @RequestParam(value = "direction",    defaultValue = "ASC") String direction,
    @RequestParam(value = "orderBy",      defaultValue = "id") String orderBy,
    @RequestParam(value = "name",         defaultValue = "") String nome )
    {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
        Page <Dtoevento> list = srvc.getcliente(pageRequest, nome);
        return ResponseEntity.ok().body(list);

    }
    
        @GetMapping("{id}")
        public ResponseEntity<Dtoevento>getclienteById(@PathVariable long id)
    {
        Dtoevento dto = srvc.getclientebyId(id);
        return ResponseEntity.ok().body(dto);    
    
    }
    @PostMapping
    public ResponseEntity<Dtoevento> insert(@RequestBody Dtoinsert insertDto){
        Dtoevento dto = srvc.insert(insertDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> apagarById(@PathVariable Long id){
        srvc.apagarId(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Dtoevento> update(@RequestBody Dtoevento updateDto, @PathVariable Long id){
    Dtoevento dto = srvc.atualizar(id,updateDto);
    return ResponseEntity.ok().body(dto);}
    
}