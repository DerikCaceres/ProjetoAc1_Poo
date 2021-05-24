package com.example.projetoac1.dtoAdm;

import com.example.projetoac1.entities.AdminEntity;

public class DtoAdm {


    private long id;
    private String name;
    private String phone;
    private String email;

    public DtoAdm() {
    }

    public DtoAdm(long id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
    
    public DtoAdm(AdminEntity adm) {
        this.id= adm.getId();
        this.name= adm.getName();
        this.phone = adm.getPhone();
        this.email= adm.getEmail();
    }

    public DtoAdm(DtoAdm adm) {
        this.id = adm.getId();
        this.name = adm.getName();
        this.email = adm.getEmail();
        this.phone = adm.getPhone();
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
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    
    
}
