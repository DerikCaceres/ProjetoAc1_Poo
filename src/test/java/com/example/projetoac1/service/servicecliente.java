package com.example.projetoac1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.projetoac1.Dto.Dtocliente;
import com.example.projetoac1.entities.cliente;
import com.example.projetoac1.repositorio.clienterepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class servicecliente {
    
    @Autowired
    private clienterepositorio repository;


    public List<Dtocliente> getcliente()
    {
        List<cliente> list = repository.findAll();
        return DtoList(list);
    }
    public Dtocliente getclientebyId(Long id)
    {
        Optional <cliente> op = repository.findById(id);
        cliente cliente = op.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"nada encontrado no sistema."));
        return new Dtocliente(cliente);
    }
    private List<Dtocliente> DtoList(List <cliente>list)
    {
        List<Dtocliente> DtoList = new ArrayList<>();

        for(cliente c : list){
            DtoList.add(new Dtocliente(c.getId(),c.getName()));
        }
        return DtoList;
    }
    public void apagarId(Long id) {
    }
    public Dtocliente atualizar(Long id, Dtocliente updateDto) {
        return null;
    }
}