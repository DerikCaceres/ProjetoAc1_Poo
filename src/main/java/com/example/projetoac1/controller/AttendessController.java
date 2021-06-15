package com.example.projetoac1.controller;



import java.net.URI;

import com.example.projetoac1.dtoAttendess.attendessDto;
import com.example.projetoac1.dtoAttendess.attendessDtoInsert;
import com.example.projetoac1.dtoAttendess.attendessDtoUP;
import com.example.projetoac1.service.AtteendessService;


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
    private AtteendessService AttendessService;
    
    @GetMapping
    public ResponseEntity<Page<attendessDto>>getAttendees(

        @RequestParam(value = "page",         defaultValue = "0") Integer page,//?page=1
        @RequestParam(value = "linesPerPage", defaultValue = "6") Integer linesPerPage,//?page=1&perpage=4
        @RequestParam(value = "direction",    defaultValue = "ASC") String direction,//
        @RequestParam(value = "orderBy",      defaultValue = "id") String orderBy,
        @RequestParam(value = "name",         defaultValue = "") String name
      
    ){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);

        Page <attendessDto> list = AttendessService.getAllAttendess(pageRequest,name);

        return ResponseEntity.ok().body(list);      
    }

    @GetMapping("/{id}")
    public ResponseEntity<attendessDto> getAttendessById(@PathVariable long id) {
      attendessDto Attendess = AttendessService.getAttendessById(id);
      return ResponseEntity.ok().body(Attendess);  
    }

    @PostMapping
    public ResponseEntity<attendessDto> insert(@RequestBody attendessDtoInsert insertDto){
      attendessDto dto = AttendessService.insert(insertDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable long id){
      AttendessService.deleteId(id);
      return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<attendessDto> Update(@RequestBody attendessDtoUP updateDto, @PathVariable Long id){
      attendessDto dto = AttendessService.update(id,updateDto);
        return ResponseEntity.ok().body(dto);
    }
}
