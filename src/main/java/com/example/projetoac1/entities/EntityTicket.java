package com.example.projetoac1.entities;

import java.time.Instant;

import javax.persistence.Table;



@Table(name="TB_TICKET")
public class EntityTicket {

    private long id;
    private Instant date;
    private Double price;


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Instant getDate() {
        return date;
    }
    public void setDate(Instant date) {
        this.date = date;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }



    
    
}
