package com.example.projetoac1.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


import com.example.projetoac1.dtoAttendess.attendessDtoInsert;


@Entity
@PrimaryKeyJoinColumn(name="USERBASE_ID")
@Table(name="TB_ATTENDESS")
public class AttendessEntity extends BaseUser{

 //   @OneToMany //@OneToMany(cascade = CascadeType.ALL)  =
  //  @JoinColumn(name="Balance")
    private double balance;

    

    public AttendessEntity() {
    }

    
    
    public AttendessEntity(long id, String name, String email, double balance) {
        super(id, name, email);
        this.balance = balance;
    }



    public AttendessEntity(attendessDtoInsert insertDto) {
        super(insertDto.getId(),insertDto.getName());
        this.balance = insertDto.getBalance();

    }



    public double getBalance() {
        return balance;
    }




    public void setBalance(double balance) {
        this.balance = balance;
    }




    
  


 

    

    
}