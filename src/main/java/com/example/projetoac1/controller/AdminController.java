//Derik Caceres 190695
package com.example.projetoac1.controller;

import java.net.URI;

import com.example.projetoac1.dtoAdm.AdminDto;
import com.example.projetoac1.dtoAdm.AdminDtoInsert;
import com.example.projetoac1.dtoAdm.AdminDtoUp;
import com.example.projetoac1.service.AdminService;

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
public class AdminController {

    @Autowired
    private AdminService adminService;



    @GetMapping
    public ResponseEntity<Page<AdminDto>>getAdmin(

        @RequestParam(value = "page",         defaultValue = "0") Integer page,//?page=1
        @RequestParam(value = "linesPerPage", defaultValue = "6") Integer linesPerPage,//?page=1&perpage=4
        @RequestParam(value = "direction",    defaultValue = "ASC") String direction,//
        @RequestParam(value = "orderBy",      defaultValue = "id") String orderBy,
        @RequestParam(value = "name",         defaultValue = "") String name,
        @RequestParam(value = "phoneNumber",      defaultValue = "") String phoneNumber,
        @RequestParam(value = "email",         defaultValue = "") String email
    ){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);

        Page <AdminDto> list = adminService.getAdmin(pageRequest,name,phoneNumber,email);

        return ResponseEntity.ok().body(list);      
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminDto> getAdminById(@PathVariable long id) {
      AdminDto admin = adminService.getAdminById(id);
      return ResponseEntity.ok().body(admin);  
    }

  
    @PostMapping
    public ResponseEntity<AdminDto> insert(@RequestBody AdminDtoInsert insertDto){
        AdminDto dto = adminService.insert(insertDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable long id){
      adminService.Remove(id);
      return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<AdminDto> Update(@RequestBody AdminDtoUp updateDto, @PathVariable Long id){
      AdminDto dto = adminService.atualizar(id,updateDto);
        return ResponseEntity.ok().body(dto);
    }
}
