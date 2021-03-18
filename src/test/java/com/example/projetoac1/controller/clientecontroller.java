package com.example.projetoac1.controller;

import java.util.List;

import com.example.projetoac1.Dto.Dtocliente;
import com.example.projetoac1.service.servicecliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class clientecontroller 
{

    @Autowired
    private servicecliente service;

    @GetMapping
    public ResponseEntity<List<Dtocliente>> getcliente()
    {
        List <Dtocliente> list = service.getcliente();
        return ResponseEntity.ok().body(list);

    }
    
        @GetMapping("{id}")
        public ResponseEntity<Dtocliente>getclienteById(@PathVariable long id)
    {
        Dtocliente dto = service.getclientebyId(id);
        return ResponseEntity.ok().body(dto);    
    
    }
    
}
