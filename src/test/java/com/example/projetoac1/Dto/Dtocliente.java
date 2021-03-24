package com.example.projetoac1.Dto;

import com.example.projetoac1.entities.cliente;

public class Dtocliente {

    private String name;
    private long id;
    
    
    public Dtocliente(){
    }

   
    public Dtocliente(cliente cli) {
        setId(cli.getId());
        setnome(cli.getName());
    }
    public Dtocliente(long id, String name) {

        setId(id);
        setnome(name);
    }
    public long getId() {
        return id;
    }
  
    public String getnome() {
        return name;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setnome(String name) {
        this.name = name;
    }
}