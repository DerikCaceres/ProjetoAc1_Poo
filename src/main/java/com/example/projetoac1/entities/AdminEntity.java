package com.example.projetoac1.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.example.projetoac1.dtoAdm.AdminDtoInsert;




@Entity
@PrimaryKeyJoinColumn(name="USERBASE_ID")
@Table(name="TB_ADMIN")
public class AdminEntity extends BaseUser{

 

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="ADMIN_ID")
    private List<EventsCadastro> listaEventos = new ArrayList<>();


    private String phoneNumber;


    public AdminEntity() {
    }


    public AdminEntity(long id, String name, String email, List<EventsCadastro> listaEventos, String phoneNumber) {
        super(id, name, email);
        this.listaEventos = listaEventos;
        this.phoneNumber = phoneNumber;
    }


    public AdminEntity(AdminDtoInsert insertDto) {
        super(insertDto.getId(), insertDto.getName(), insertDto.getEmail());
        this.phoneNumber = insertDto.getPhoneNumber();
    }


    


    public List<EventsCadastro> getListaEventos() {
        return listaEventos;
    }


    public void setListaEventos(List<EventsCadastro> listaEventos) {
        this.listaEventos = listaEventos;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
}
