package com.example.projetoac1.Dto;

import java.time.LocalDate;
import java.time.LocalTime;


import com.example.projetoac1.entities.EventsCadastro;

public class EventDto {

    private Long id;
    private String name;
    private String  description;
    private String  place;
    private String email;
    
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;



    public EventDto(){
    }

    public EventDto(long id,String Name, String  description, String place, LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime, String email) 
    { 
        this.id = id;
        this.name = Name;
        this.description = description;
        this.place = place;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.email = email;
        
        /*setId(id);
        setNome(Nome);
        setDescricao(descricao);
        setLugar(lugar);
        setStartDate(startDate);
        setEndDate(endDate);
        setStartTime(startTime);                    
        setEndTime(endTime);
        setEmail(email);*/
        
    }

    public EventDto(EventsCadastro c){
        
        this.id = c.getId();
        this.name = c.getName();
        this.description = c.getDescription();
        this.place = c.getPlace();
        this.email = c.getEmail();
        this.startDate = c.getStartDate();
        this.endDate = c.getEndDate();
        this.startTime = c.getStartTime();
        this.endTime = c.getEndTime();
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

  

}
