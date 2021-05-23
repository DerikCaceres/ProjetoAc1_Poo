package com.example.projetoac1.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.example.projetoac1.dtoAttendess.DtoAttendess;
import com.example.projetoac1.dtoAttendess.DtoAttendessInsert;
import com.example.projetoac1.entities.AttendessEntity;
import com.example.projetoac1.repositorio.AttendessRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;  


@Service
public class AttenService {
    @Autowired
    private AttendessRepository repository;

    public Page<DtoAttendess> getAllAttendess(PageRequest pageRequest,String name)
    {

        Page <AttendessEntity> list = repository.find(pageRequest, name);
        return list.map(c -> new DtoAttendess(c));

    } 

    public DtoAttendess getAttendessById(long id){

        Optional <AttendessEntity> op = repository.findById(id);
        AttendessEntity attendess = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado no sistema!!!"));

        return new DtoAttendess(attendess);
    } 

    public DtoAttendess insert(DtoAttendessInsert insertDto){

        AttendessEntity entity = new AttendessEntity(insertDto);
        entity = repository.save(entity);
        return new DtoAttendess(entity);
    }

    public void deleteId(Long id){
        try{
            repository.deleteById(id);
        }
        catch(EmptyResultDataAccessException e)  {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ID já apagado ou não encontrado");
        }
    }

    public DtoAttendess update(long id, DtoAttendess updateDto)
    {
        try{
            AttendessEntity entity = repository.getOne(id);
            entity.setName(updateDto.getName());
            entity=repository.save(entity);
            return new DtoAttendess(entity);
        }catch(EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ID não encontrado no Sistema!!!");
        }
    }
}
