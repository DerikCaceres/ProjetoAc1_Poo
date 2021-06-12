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


import com.example.projetoac1.Dto.EventDtoInsert;



@Entity
@Table(name="TB_EVENTS")//quando o nome da tabela nao bate com a do banco de dados tenho que colocar @table 
public class EventsCadastro implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @ManyToMany()
    private List<PlaceEntity> listPlace = new ArrayList<PlaceEntity>();

    private AdminEntity admin;
    

    private String name;
    private String description;
    private String email;

    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;


   


    public EventsCadastro() {
        
    }

    public EventsCadastro(AdminEntity admin, String name, String description,  String email,
            LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime) {
        
        this.admin = admin;
        this.name = name;
        this.description = description;

        this.email = email;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    public EventsCadastro(EventDtoInsert insertDto) {
    
        this.name = insertDto.getName();
        this.description = insertDto.getDescription();
        this.email = insertDto.getEmail();
        this.startDate = insertDto.getStartDate();
        this.endDate = insertDto.getEndDate();
        this.startTime = insertDto.getStartTime();
        this.endTime = insertDto.getEndTime();
    }

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public AdminEntity getAdmin() {
        return admin;
    }


    public void setAdmin(AdminEntity admin) {
        this.admin = admin;
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

    public List<PlaceEntity> getListPlace() {
        return listPlace;
    }

    public void addPlace(PlaceEntity place) {
        this.listPlace.add(place);
    }

    public Boolean getPlacebyId(Long id)  {

        for (PlaceEntity placeEntity : listPlace) {
            if(placeEntity.getId() == id) {
                return true;
            }
        }

        return false;


    }




    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
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
        EventsCadastro other = (EventsCadastro) obj;
        if (id != other.id)
            return false;
        return true;
    }


   

    
}
