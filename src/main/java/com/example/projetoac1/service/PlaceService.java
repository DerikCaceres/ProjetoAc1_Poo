package com.example.projetoac1.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.example.projetoac1.DtoPlace.DtoPlace;
import com.example.projetoac1.DtoPlace.DtoPlaceInser;
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
    private PlaceRepository repository;

    public Page<DtoPlace> getAll(PageRequest pageRequest, String name, String adress)
    {

        Page <PlaceEntity> list = repository.find(pageRequest,name,adress);
        return list.map(c -> new DtoPlace(c));

    } 

    public DtoPlace getPlaceById(long id){

        Optional <PlaceEntity> op = repository.findById(id);
        PlaceEntity place = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado no sistema!!!"));

        return new DtoPlace(place);
    } 

    public DtoPlace insert(DtoPlaceInser insertDto){

        PlaceEntity place = new PlaceEntity(insertDto);
        place = repository.save(place);
        return new DtoPlace(place);
    }

    public void deleteId(Long id){
        try{
            repository.deleteById(id);
        }
        catch(EmptyResultDataAccessException e)  {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ID já apagado ou não encontrado");
        }
    }

    public DtoPlace update(long id, DtoPlace updateDto)
    {
        try{
            PlaceEntity place = repository.getOne(id);
            place.setName(updateDto.getName());
            place=repository.save(place);
            return new DtoPlace(place);
        }catch(EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ID não encontrado no Sistema!!!");
        }
    }
}
