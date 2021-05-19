package com.example.projetoac1.dtoAdm;

import com.example.projetoac1.entities.AdminEntity;

public class DtoAdm {


    private long id;
    private String name;
    private String telefone;
    private String email;


    

    public DtoAdm() {
    }
    public DtoAdm(DtoAdm adm) {
    }

    public DtoAdm(long id, String name, String telefone, String email) {
        this.id = id;
        this.name = name;
        this.telefone = telefone;
        this.email = email;
    }
    
    
    public DtoAdm(AdminEntity adm) {
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
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    
    
}
