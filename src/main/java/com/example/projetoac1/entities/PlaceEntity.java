package com.example.projetoac1.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import com.example.projetoac1.DtoPlace.PlaceInsertDto;

@Entity
@Table(name="TB_PLACE")
public class PlaceEntity {




    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    
    private String name;
    private String address;



    @ManyToMany()
    private List<EventsCadastro> eventos = new ArrayList<EventsCadastro>();

    public PlaceEntity() {
        
    }

    public PlaceEntity(PlaceInsertDto insertDto) {
        this.id = insertDto.getId();
        this.name = insertDto.getName();
        this.address = insertDto.getAddress();

    }



    public long getId() {
        return id;
    }



    public void setId(long id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public String getAddress() {
        return address;
    }



    public void setAddress(String address) {
        this.address = address;
    }
    
}