package com.example.projetoac1.DtoPlace;



import com.example.projetoac1.entities.PlaceEntity;

public class DtoPlace {
    private long id;
    private String name;
    private String adress;

    public DtoPlace(PlaceEntity e) {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    
}
