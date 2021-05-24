package com.example.projetoac1.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.example.projetoac1.dtoAdm.DtoAdmInsert;


@Entity
@PrimaryKeyJoinColumn(name="USERBASE_ID")
@Table(name="TB_ADMIN")
public class AdminEntity extends BaseUser{

 

    @OneToMany(cascade = CascadeType.ALL)  
    @JoinColumn(name="Adm_Id")
    private List<Evento> eventList = new ArrayList<>();


    private String phone;


    public AdminEntity() {
    }


    public AdminEntity(long id, String name, String email, List<Evento> eventList, String phone) {
        super(id,name,email);
        this.eventList = eventList;
        this.phone = phone;
    }


    public AdminEntity(DtoAdmInsert insertDto) {
        super(insertDto.getId(), insertDto.getName(), insertDto.getEmail());
        this.phone = insertDto.getPhone();
    }

    public List<Evento> getEventList() {
        return eventList;
    }


    public void setEventList(List<Evento> eventList) {
        this.eventList = eventList;
    }


    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }
 


 



    
}
