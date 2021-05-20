package com.example.projetoac1.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.example.projetoac1.DtoPlace.DtoPlaceInser;

@Entity
public class PlaceEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    private String name;
    private String address;

    @ManyToMany()
    private List<Evento> eventlist = new ArrayList<Evento>();



    public PlaceEntity(PlaceEntity entity) {
    }
    public PlaceEntity(DtoPlaceInser insertDto) {
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
