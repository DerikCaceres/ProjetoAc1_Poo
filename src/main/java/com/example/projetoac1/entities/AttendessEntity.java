package com.example.projetoac1.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import com.example.projetoac1.dtoAttendess.DtoAttendessInsert;


@Entity
@PrimaryKeyJoinColumn(name="USERBASE_ID")
public class AttendessEntity extends BaseUser{

    private double balance;

    

    public AttendessEntity() {
    }

    
    
    public AttendessEntity(long id, String name, String email, double balance) {
        super(id, name, email);
        this.balance = balance;
    }



    public AttendessEntity(DtoAttendessInsert insertDto) {
    }



    public double getBalance() {
        return balance;
    }




    public void setBalance(double balance) {
        this.balance = balance;
    }




    
  


 

    

    
}
