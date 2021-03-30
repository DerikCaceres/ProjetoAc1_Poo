package com.example.projetoac1.Dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.example.projetoac1.entities.evento;

public class Dtoevento {

    private Long id;
    private String name;
    private String descricao;
    private String local;

    private LocalDate datainicio;
    private LocalDate datafinal;
    private LocalTime tempoinicio;
    private LocalTime tempofinal;

    private String email;

    public Dtoevento(){ 

    }
    
    public Dtoevento(String name, String local, LocalDate datainicio, LocalDate datafinal, LocalTime tempoinicio,  LocalTime  tempofinal, String email){
        
       
        this.name = name;
        this.local = local;
        this.datainicio = datainicio;
        this.datafinal = datafinal;
        this.tempoinicio = tempoinicio;
        this.tempofinal = tempofinal;
        this.email = email;
    }

    public Dtoevento(evento ev) {
        this.name = ev.getName();
        this.descricao = ev.getDescricao();
        this.local = ev.getLocal();
        this.datainicio = ev.getDatainicio();
        this.datafinal = ev.getDatafinal();
        this.tempoinicio = ev.getTempoinicio();
        this.tempofinal = ev.getTempofinal();
        this.email = ev.getEmail();
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
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }
    public LocalDate Datainicio() {
        return datainicio;
    }
    public void setDatainicio(LocalDate datainicio) {
        this.datainicio = datainicio;
    }
    public LocalDate getDatafinal() {
        return datafinal;
    }
    public void setDatafinal(LocalDate datafinal) {
        this.datafinal = datafinal;
    }
    public LocalTime  getTempoinicio() {
        return tempoinicio;
    }
    public void setTempoinicio(LocalTime tempoinicio) {
        this.tempoinicio = tempoinicio;
    }
    public LocalTime  getTempofinal() {
        return tempofinal;
    }
    public void setTempofinal(LocalTime tempofinal) {
        this.tempofinal = tempofinal;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}