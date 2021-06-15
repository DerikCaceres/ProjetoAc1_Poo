package com.example.projetoac1.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;


import com.example.projetoac1.DtoPlace.PlaceDto;
import com.example.projetoac1.DtoPlace.PlaceInsertDto;
import com.example.projetoac1.DtoPlace.PlaceUpdateDto;
import com.example.projetoac1.entities.PlaceEntity;
import com.example.projetoac1.repositorio.PlaceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PlaceService {
    
     @Autowired
     private PlaceRepository RepositoryPlace;
     
     public Page<PlaceDto> getPlace(PageRequest pageRequest, String name, String address)
     {
         
         Page<PlaceEntity> list = RepositoryPlace.find(pageRequest,name,address);
         return list.map( pl -> new PlaceDto(pl));
     }
     
     public PlaceDto getPlaceById(Long id){
 
        Optional<PlaceEntity> op = RepositoryPlace.findById(id);
        PlaceEntity place = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Place not found"));
 
        return new PlaceDto(place);
     }
 
     public PlaceDto insert(PlaceInsertDto insertDto) {

        PlaceEntity place = new PlaceEntity(insertDto);
        place = RepositoryPlace.save(place);
        return new PlaceDto(place);
     }
     public PlaceDto update(Long id, PlaceUpdateDto updateDto){
       
        try{
            PlaceEntity PlaceEntity = RepositoryPlace.getOne(id);

            PlaceEntity.setName(updateDto.getName());
            PlaceEntity.setAddress(updateDto.getAddress());
            PlaceEntity = RepositoryPlace.save(PlaceEntity);
            return new PlaceDto(PlaceEntity);
        }
         catch(EntityNotFoundException e){
             throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Place not found");
         }
     }
     
     public void remove(Long id){
         try {
             RepositoryPlace.deleteById(id);
         } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
         }
     }
     
     
}
