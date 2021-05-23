package com.example.projetoac1.controller;

import java.net.URI;

import com.example.projetoac1.dtoAdm.DtoAdm;
import com.example.projetoac1.dtoAdm.DtoAdmInsert;
import com.example.projetoac1.service.AdmService;

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
@RequestMapping("/admins")
public class AdmController {

    @Autowired
    private AdmService adminService;



    @GetMapping
    public ResponseEntity<Page<DtoAdm>>getAdmin(

        @RequestParam(value = "page",         defaultValue = "0") Integer page,
        @RequestParam(value = "linesPerPage", defaultValue = "6") Integer linesPerPage,
        @RequestParam(value = "direction",    defaultValue = "ASC") String direction,
        @RequestParam(value = "orderBy",      defaultValue = "id") String orderBy,
        @RequestParam(value = "nome",         defaultValue = "") String name,
        @RequestParam(value = "telefone",      defaultValue = "") String telefone,
        @RequestParam(value = "email",         defaultValue = "") String email
    ){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);

        Page <DtoAdm> list = adminService.getAdmin(pageRequest,name,telefone,email);

        return ResponseEntity.ok().body(list);      
    }
    @GetMapping("/{id}")
    public ResponseEntity<DtoAdm> getAdminById(@PathVariable long id) {
        DtoAdm admin = adminService.getAdminByCodigo(id);
      return ResponseEntity.ok().body(admin);  
    }
    @PostMapping
    public ResponseEntity<DtoAdm> insert(@RequestBody DtoAdmInsert insertDto){
        DtoAdm dto = adminService.insert(insertDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable long id){
      adminService.Remove(id);
      return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}")
    public ResponseEntity<DtoAdm> Update(@RequestBody DtoAdm updateDto, @PathVariable Long id){
        DtoAdm dto = adminService.atualizar(id,updateDto);
        return ResponseEntity.ok().body(dto);
    }
}

