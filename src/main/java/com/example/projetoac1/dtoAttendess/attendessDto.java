package com.example.projetoac1.dtoAttendess;

import com.example.projetoac1.entities.AttendessEntity;

public class attendessDto {

    private Long id;
    private String name;  
    private double balance;


    public attendessDto(){

    }
   
    public attendessDto(AttendessEntity c) {
        this.id= c.getId();
        this.name= c.getName();
        this.balance= c.getBalance();
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
    public void setBalance(double balance) {
        this.balance = balance;
    }


    
    
}



    
    

