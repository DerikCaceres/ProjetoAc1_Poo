package com.example.projetoac1.controller;

import java.util.List;

import com.example.projetoac1.Dto.Dtocliente;
import com.example.projetoac1.service.servicecliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/cliente")
public class clientecontroller 
{

    @Autowired
    private servicecliente srvc;

    @GetMapping
    public ResponseEntity<List<Dtocliente>> getcliente()
    {
        List <Dtocliente> list = srvc.getcliente();
        return ResponseEntity.ok().body(list);

    }
    
        @GetMapping("{id}")
        public ResponseEntity<Dtocliente>getclienteById(@PathVariable long id)
    {
        Dtocliente dto = srvc.getclientebyId(id);
        return ResponseEntity.ok().body(dto);    
    
    }
    @PostMapping
    public ResponseEntity<Dtocliente> insert(@RequestBody DtoclienteInsert insertDto){
        Dtocliente dto = srvc.insert(insertDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> apagarById(@PathVariable Long id){
        srvc.apagarId(id);;
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Dtocliente> update(@RequestBody Dtocliente updateDto, @PathVariable Long id){
    Dtocliente dto = srvc.atualizar(id,updateDto);
    return ResponseEntity.ok().body(dto);}
    
}
