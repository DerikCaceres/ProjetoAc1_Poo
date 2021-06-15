package com.example.projetoac1.dtoAdm;

import com.example.projetoac1.entities.AdminEntity;

public class AdminDto {


    private long id;
    private String name;
    private String phoneNumber;
    private String email;

  

    public AdminDto() {
    }

    public AdminDto(long id, String name, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    
    public AdminDto(AdminEntity admin) {
        this.id= admin.getId();
        this.name= admin.getName();
        this.phoneNumber = admin.getPhoneNumber();
        this.email= admin.getEmail();
    }   

    public AdminDto(AdminDto adm) {
        this.id = adm.getId();
        this.name = adm.getName();
        this.email = adm.getEmail();
        this.phoneNumber = adm.getPhoneNumber();
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

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }   
    
}