package com.example.Book_My_Show_May.Entities;

//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="theaters")
//@Data
//@NoArgsConstructor
public class TheaterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String name ;
    private String location ;


    //this is a parent class and child class theaterSet
    @OneToMany(mappedBy = "theaterEntity" , cascade = CascadeType.ALL)
    private List<TheaterSeatEntity> theaterSeatEntityList = new ArrayList<>();


    //this is a parent class(TheaterEntity) and child class (ShowEntity)
    @OneToMany(mappedBy = "theaterEntity",cascade = CascadeType.ALL)
    private List<ShowEntity>showEntityList=new ArrayList<>();

    public TheaterEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<TheaterSeatEntity> getTheaterSeatEntityList() {
        return theaterSeatEntityList;
    }

    public void setTheaterSeatEntityList(List<TheaterSeatEntity> theaterSeatEntityList) {
        this.theaterSeatEntityList = theaterSeatEntityList;
    }

    public List<ShowEntity> getShowEntityList() {
        return showEntityList;
    }

    public void setShowEntityList(List<ShowEntity> showEntityList) {
        this.showEntityList = showEntityList;
    }


}
