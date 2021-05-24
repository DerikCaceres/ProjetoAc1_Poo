package com.example.projetoac1.controller;

import java.net.URI;

import com.example.projetoac1.DtoPlace.DtoPlace;
import com.example.projetoac1.DtoPlace.DtoPlaceInser;
import com.example.projetoac1.service.PlaceService;


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
@RequestMapping("/places")
public class PlaceController {
    
    
    @Autowired
    private PlaceService PlaceService;



    @GetMapping
    public ResponseEntity<Page<DtoPlace>>getAdmin(

        @RequestParam(value = "page",         defaultValue = "0") Integer page,
        @RequestParam(value = "linesPerPage", defaultValue = "6") Integer linesPerPage,
        @RequestParam(value = "direction",    defaultValue = "ASC") String direction,
        @RequestParam(value = "orderBy",      defaultValue = "id") String orderBy,
        @RequestParam(value = "name",         defaultValue = "") String name,
        @RequestParam(value = "Adress",      defaultValue = "") String Adress
     
    ){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);

        Page <DtoPlace> list = PlaceService.getAll(pageRequest,name,Adress);

        return ResponseEntity.ok().body(list);      
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoPlace> getPlaceById(@PathVariable long id) {
        DtoPlace place = PlaceService.getPlaceById(id);
      return ResponseEntity.ok().body(place);  
    }

  
    @PostMapping
    public ResponseEntity<DtoPlace> insert(@RequestBody DtoPlaceInser insertDto){
        DtoPlace dto = PlaceService.insert(insertDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable long id){
      PlaceService.deleteId(id);
      return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<DtoPlace> Update(@RequestBody DtoPlace updateDto, @PathVariable Long id){
        DtoPlace dto = PlaceService.update(id,updateDto);
        return ResponseEntity.ok().body(dto);
    }
}
