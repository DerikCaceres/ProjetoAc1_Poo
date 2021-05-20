package com.example.projetoac1.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.example.projetoac1.Dto.Dtoinsert;



@Entity
@Table(name = "Evento_tabela")
public class Evento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToMany()
    private List<PlaceEntity> placelist = new ArrayList<PlaceEntity>();
    private AdminEntity adm;
    private String name;
    private String descricao;
    private String local;

    private LocalDate datainicio;
    private LocalDate datafinal;
    private LocalTime tempoinicio;
    private LocalTime tempofinal;

    private String email;
    public Evento() {   
    }
    public Evento(Dtoinsert dto) {
       
            this.name = dto.getName();
            this.descricao = dto.getDescricao();
            this.local = dto.getLocal();
            this.datainicio = dto.getDatainicio();
            this.datafinal = dto.getDatafinal();
            this.tempoinicio = dto.getTempoinicio();
            this.tempofinal = dto.getTempofinal();
            this.email = dto.getEmail();
        
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
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }
    public LocalDate getDatainicio() {
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
    public LocalTime getTempoinicio() {
        return tempoinicio;
    }
    public void setTempoinicio(LocalTime tempoinicio) {
        this.tempoinicio = tempoinicio;
    }
    public LocalTime getTempofinal() {
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
    
    
    
    public List<PlaceEntity> getPlacelist() {
        return placelist;
    }
    public void setPlacelist(List<PlaceEntity> placelist) {
        this.placelist = placelist;
    }
    public AdminEntity getAdm() {
        return adm;
    }
    public void setAdm(AdminEntity adm) {
        this.adm = adm;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int)(id ^ (id >>> 32));
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Evento other = (Evento) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    
}
}
