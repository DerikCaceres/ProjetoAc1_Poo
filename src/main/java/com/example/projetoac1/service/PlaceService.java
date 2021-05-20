package com.example.projetoac1.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.example.projetoac1.DtoPlace.DtoPlace;
import com.example.projetoac1.DtoPlace.DtoPlaceInser;
import com.example.projetoac1.entities.PlaceEntity;
import com.example.projetoac1.repositorio.PlaceRepository;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PlaceService {
    private PlaceRepository repository;

    public Page<DtoPlace> getAll(PageRequest pageRequest)
    {

        Page <PlaceEntity> list = repository.find(pageRequest);
        return list.map(e -> new DtoPlace(e));

    } 

    public DtoPlace getPlaceById(long id){

        Optional <PlaceEntity> op = repository.findById(id);
        PlaceEntity attendess = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado no sistema!!!"));

        return new DtoPlace(attendess);
    } 

    public DtoPlace insert(DtoPlaceInser insertDto){

        PlaceEntity entity = new PlaceEntity(insertDto);
        entity = repository.save(entity);
        return new DtoPlace(entity);
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
            PlaceEntity entity = repository.getOne(id);
            entity.setName(updateDto.getName());
            entity=repository.save(entity);
            return new DtoPlace(entity);
        }catch(EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ID não encontrado no Sistema!!!");
        }
    }
}
