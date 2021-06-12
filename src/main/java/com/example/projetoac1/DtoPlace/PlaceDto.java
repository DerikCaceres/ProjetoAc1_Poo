package com.example.projetoac1.DtoPlace;



import com.example.projetoac1.entities.PlaceEntity;
import com.example.projetoac1.repositorio.PlaceRepository;

public class PlaceDto {

    private long id;
    private String name;
    private String address;

    public PlaceDto(PlaceRepository placeEntity){

    }

    public PlaceDto(long id, String name, String address)
    {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public PlaceDto(PlaceEntity place) {
        this.id = place.getId();
        this.name = place.getName();
        this.address = place.getAddress();
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

