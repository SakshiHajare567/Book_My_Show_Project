package com.example.Book_My_Show_May.Entities;

import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="users")
//@Data
//@NoArgsConstructor
//@Builder
//@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;

    @Column(unique = true, nullable = false)
    private String mobNo;

    private String address;

    @Column(unique = true, nullable = false)
    private String email;

    public UserEntity() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<TicketEntity> getBookedTickets() {
        return bookedTickets;
    }

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private final List<TicketEntity> bookedTickets = new ArrayList<>();
    // Custom constructor needed for Builder

}
