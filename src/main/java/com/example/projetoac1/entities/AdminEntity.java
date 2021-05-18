package com.example.projetoac1.entities;


import java.util.List;


import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn(name="USERBASE_ID")
public class AdminEntity extends BaseUser{

 

    @OneToMany    
    @JoinColumn(name="Adm_Id")
    private List<Evento> listaEventos;


    private String telefone;


    public AdminEntity() {
    }


    public AdminEntity(long id, String name, String email, List<Evento> listaEventos, String telefone) {
        super(id,name,email);
        this.listaEventos = listaEventos;
        this.telefone = telefone;
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
