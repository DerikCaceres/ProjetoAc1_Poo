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
@Table(name = "EVENT_TABLE")
public class Evento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToMany()
    private List<PlaceEntity> placelist = new ArrayList<PlaceEntity>();
    private AdminEntity adm;
    private String name;
    private String description;
    private String place;

    private LocalDate startdate;
    private LocalDate enddate;
    private LocalTime starttime;
    private LocalTime endtime;

    private String email;
    public Evento() {   
    }
    public Evento(Dtoinsert dto) {
       
            this.name = dto.getName();
            this.description = dto.getDescription();
            this.place = dto.getPlace();
            this.startdate = dto.getStartdate();
            this.enddate = dto.getEnddate();
            this.starttime = dto.getStarttime();
            this.endtime = dto.getEndtime();
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
    public LocalDate getStartdate() {
        return startdate;
    }
    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }
    public LocalDate getEnddate() {
        return enddate;
    }
    public void setEnddate(LocalDate enddate) {
        this.enddate = enddate;
    }
    public LocalTime getStarttime() {
        return starttime;
    }
    public void setStarttime(LocalTime starttime) {
        this.starttime = starttime;
    }
    public LocalTime getEndtime() {
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
