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
    private List<Evento> listaEventos = new ArrayList<>();


    private String telefone;


    public AdminEntity() {
    }


    public AdminEntity(long id, String name, String email, List<Evento> listaEventos, String telefone) {
        super(id,name,email);
        this.listaEventos = listaEventos;
        this.telefone = telefone;
    }


    public AdminEntity(DtoAdmInsert insertDto) {
        super(insertDto.getId(), insertDto.getName(), insertDto.getEmail());
        this.telefone = insertDto.getTelefone();
    }

    public List<Evento> getListaEventos() {
        return listaEventos;
    }


    public void setListaEventos(List<Evento> listaEventos) {
        this.listaEventos = listaEventos;
    }


    public String getTelefone() {
        return telefone;
    }


    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
 


 



    
}
