package com.example.Book_My_Show_May.Entities;

import jakarta.persistence.*;
//import lombok.Data;
//import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;
@Entity
@Table(name="tickets")
//@Data
//@NoArgsConstructor

public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String theaterName;
    private LocalDate showDate ;
    private LocalTime showTime ;
    private  int totalAmount ;
    private final String  ticketId = UUID.randomUUID().toString();

    public TicketEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public LocalTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalTime showTime) {
        this.showTime = showTime;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTicketId() {
        return ticketId;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public ShowEntity getShowEntity() {
        return showEntity;
    }

    public void setShowEntity(ShowEntity showEntity) {
        this.showEntity = showEntity;
    }

    // This is child class(TicketEntity)and parent class(UserEntity)
    @ManyToOne
    @JoinColumn
    private UserEntity userEntity;

    // This is child class(TicketEntity)and parent class(ShowEntity)
    @ManyToOne
    @JoinColumn
    private ShowEntity showEntity;

}
