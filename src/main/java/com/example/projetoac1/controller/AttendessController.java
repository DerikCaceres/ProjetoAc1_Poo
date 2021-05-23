package com.example.projetoac1.controller;



import java.net.URI;


import com.example.projetoac1.dtoAttendess.DtoAttendess;
import com.example.projetoac1.dtoAttendess.DtoAttendessInsert;
import com.example.projetoac1.service.AttenService;

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
@RequestMapping("/attendess")
public class AttendessController {

    @Autowired
    private AttenService service;


    @GetMapping
    public ResponseEntity<Page<DtoAttendess>>getAttendess(

        @RequestParam(value = "page",         defaultValue = "0") Integer page,
        @RequestParam(value = "linesPerPage", defaultValue = "6") Integer linesPerPage,
        @RequestParam(value = "direction",    defaultValue = "ASC") String direction,
        @RequestParam(value = "orderBy",      defaultValue = "id") String orderBy,
        @RequestParam(value = "name",      defaultValue = "") String name
    
    ){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);

        Page <DtoAttendess> list =service.getAllAttendess(pageRequest,name);

        return ResponseEntity.ok().body(list);      
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoAttendess> getAdminById(@PathVariable long id) {
        DtoAttendess attendess = service.getAttendessById(id);
      return ResponseEntity.ok().body(attendess);  
    }

    @PostMapping
    public ResponseEntity<DtoAttendess> insert(@RequestBody DtoAttendessInsert insertDto){
        DtoAttendess dto = service.insert(insertDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable long id){
      service.deleteId(id);
      return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<DtoAttendess> Update(@RequestBody DtoAttendess updateDto, @PathVariable Long id){
        DtoAttendess dto = service.update(id,updateDto);
        return ResponseEntity.ok().body(dto);
    }
}

