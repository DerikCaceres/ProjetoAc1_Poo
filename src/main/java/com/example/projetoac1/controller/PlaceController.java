package com.example.projetoac1.controller;

import java.net.URI;


import com.example.projetoac1.DtoPlace.PlaceDto;
import com.example.projetoac1.DtoPlace.PlaceInsertDto;
import com.example.projetoac1.DtoPlace.PlaceUpdateDto;
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
    private PlaceService placeService;



    @GetMapping
    public ResponseEntity<Page<PlaceDto>>getAdmin(

        @RequestParam(value = "page",         defaultValue = "0") Integer page,//?page=1
        @RequestParam(value = "linesPerPage", defaultValue = "6") Integer linesPerPage,//?page=1&perpage=4
        @RequestParam(value = "direction",    defaultValue = "ASC") String direction,//
        @RequestParam(value = "orderBy",      defaultValue = "id") String orderBy,
        @RequestParam(value = "name",         defaultValue = "") String name,
        @RequestParam(value = "Address",      defaultValue = "") String Address
    ){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);

        Page <PlaceDto> list = placeService.getPlace(pageRequest, name, Address);

        return ResponseEntity.ok().body(list);      
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaceDto> getPlaceById(@PathVariable long id) {
      PlaceDto place = placeService.getPlaceById(id);
      return ResponseEntity.ok().body(place);  
    }

  
    @PostMapping
    public ResponseEntity<PlaceDto> insert(@RequestBody PlaceInsertDto insertDto){
        PlaceDto dto = placeService.insert(insertDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable long id){
      placeService.remove(id);
      return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<PlaceDto> Update(@RequestBody PlaceUpdateDto updateDto, @PathVariable Long id){
      PlaceDto dto = placeService.update(id,updateDto);
        return ResponseEntity.ok().body(dto);
    }


    
}
