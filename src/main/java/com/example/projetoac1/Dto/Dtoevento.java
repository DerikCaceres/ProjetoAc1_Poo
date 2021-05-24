package com.example.projetoac1.Dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.example.projetoac1.entities.Evento;

public class DtoEvento {

    private Long id;
    private String name;
    private String description;
    private String place;

    private LocalDate startdate;
    private LocalDate enddate;
    private LocalTime starttime;
    private LocalTime endtime;

    private String email;

    public DtoEvento(){ 
    }
    
    public DtoEvento(Long id,String name, String description,String place, LocalDate startdate, LocalDate enddate, LocalTime starttime,  LocalTime  endtime, String email){
        
       
        this.id = id;
        this.name = name;
        this.description = description;
        this.place = place;
        this.startdate = startdate;
        this.enddate = enddate;
        this.starttime = starttime;
        this.endtime = endtime;
        this.email = email;
    }

    public DtoEvento(Evento eve) {
        this.id = eve.getId();
        this.name = eve.getName();
        this.description = eve.getDescription();
        this.place = eve.getPlace();
        this.startdate = eve.getStartdate();
        this.enddate = eve.getEnddate();
        this.starttime = eve.getStarttime();
        this.endtime = eve.getEndtime();
        this.email = eve.getEmail();
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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }
    public LocalDate getStartdate() {
        return startdate;
    }
    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }
    public LocalDate getEndDate() {
        return enddate;
    }
    public void setEndDate(LocalDate enddate) {
        this.enddate = enddate;
    }
    public LocalTime  getStarttime() {
        return starttime;
    }
    public void setStarttime(LocalTime starttime) {
        this.starttime = starttime;
    }
    public LocalTime  getEndtime() {
        return endtime;
    }
    public void setEndtime(LocalTime endtime) {
        this.endtime = endtime;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}