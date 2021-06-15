package com.example.projetoac1.entities;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="TB_TICKET")
public class TicketEntity {


    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    private Instant date;
    private Double price;

    private AttendessEntity attendess;
    

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
    public AttendessEntity getAttendess() {
        return attendess;
    }
    public void setAttendess(AttendessEntity attendess) {
        this.attendess = attendess;
    }
      
}
