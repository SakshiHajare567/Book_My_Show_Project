package com.example.Book_My_Show_May.Entities;

import com.example.Book_My_Show_May.Enums.SeatType;
//mport jakarta.persistence.*;

import javax.persistence.*;
//import lombok.Data;
//import lombok.NoArgsConstructor;

@Entity
@Table(name="theater_seat")
//@Data
//@NoArgsConstructor
public class TheaterSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String seatNo ;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;
    @ManyToOne
    @JoinColumn(name = "theater_id")  // foreign key column name
    private TheaterEntity theaterEntity;


    //This is child class of theaterseat and parent class theaterEntity
    //@ManyToOne
  //  @JoinColumn(referencedColumnName = "name")
    //private TheaterEntity theaterEntity;

    public TheaterSeatEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public TheaterEntity getTheaterEntity() {
        return theaterEntity;
    }

    public void setTheaterEntity(TheaterEntity theaterEntity) {
        this.theaterEntity = theaterEntity;
    }


}
