package com.example.projetoac1.Dto;

import com.example.projetoac1.entities.cliente;

public class Dtocliente {

    private String name;
    private long id;
    
    public Dtocliente(long nid, String nname) {
        setName(nname);
        setId(nid);
    }
    
    public Dtocliente(cliente cliente) {
        setName(cliente.getName());
        setId(cliente.getId());
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }
    
}
