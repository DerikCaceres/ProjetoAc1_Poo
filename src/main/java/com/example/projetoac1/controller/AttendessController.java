package com.example.projetoac1.controller;



import java.net.URI;

import com.example.projetoac1.dtoAdm.DtoAdm;
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

@RestController
@RequestMapping("/attendees")
public class AttendessController {

    @Autowired



    @GetMapping
    public ResponseEntity<Page<DtoAttendess>>getAdmin(

        @RequestParam(value = "page",         defaultValue = "0") Integer page,//?page=1
        @RequestParam(value = "linesPerPage", defaultValue = "6") Integer linesPerPage,//?page=1&perpage=4
        @RequestParam(value = "direction",    defaultValue = "ASC") String direction,//
        @RequestParam(value = "orderBy",      defaultValue = "id") String orderBy
    ){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);

        Page <DtoAttendess> list =AttenService.getAdmin(pageRequest);

        return ResponseEntity.ok().body(list);      
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoAttendess> getAdminById(@PathVariable long id) {
        DtoAttendess admin = AttenService.getAdminByCodigo(id);
      return ResponseEntity.ok().body(admin);  
    }

  
    @PostMapping
    public ResponseEntity<DtoAttendess> insert(@RequestBody DtoAttendessInsert insertDto){
        DtoAdm dto = AttenService.insert(insertDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }



    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> remove(@PathVariable long id){
      AttenService.Remove(id);
      return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<DtoAttendess> Update(@RequestBody DtoAdm updateDto, @PathVariable Long id){
        DtoAdm dto = AttenService.atualizar(id,updateDto);
        return ResponseEntity.ok().body(dto);
    }
}

