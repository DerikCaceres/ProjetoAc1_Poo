package com.example.projetoac1.dtoAttendess;

import com.example.projetoac1.entities.AttendessEntity;

public class DtoAttendess {

    private Long id;
    private String name; 
    private double balance;

    


    public DtoAttendess() {    
    }


    public DtoAttendess(AttendessEntity entity) {
        this.id= entity.getId();
        this.name= entity.getName();
        this.balance= entity.getBalance();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }


    
    
}
