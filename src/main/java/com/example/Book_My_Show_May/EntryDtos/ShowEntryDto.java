package com.example.Book_My_Show_May.EntryDtos;

import com.example.Book_My_Show_May.Enums.ShowType;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;

import java.time.LocalDate;
import java.time.LocalTime;

public class ShowEntryDto {
    private LocalTime showTime;
    private LocalDate showDate;
    private ShowType showType;
    private int classicSeatPrice ;
    private int premiumSeatPrice ;
    private int movie_id ;
    private int theater_id ;

    public ShowEntryDto() {
    }

    public LocalTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalTime showTime) {
        this.showTime = showTime;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public ShowType getShowType() {
        return showType;
    }

    public void setShowType(ShowType showType) {
        this.showType = showType;
    }

    public int getClassicSeatPrice() {
        return classicSeatPrice;
    }

    public void setClassicSeatPrice(int classicSeatPrice) {
        this.classicSeatPrice = classicSeatPrice;
    }

    public int getPremiumSeatPrice() {
        return premiumSeatPrice;
    }

    public void setPremiumSeatPrice(int premiumSeatPrice) {
        this.premiumSeatPrice = premiumSeatPrice;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
       this.movie_id  = movie_id;
    }

    public int getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(int theater_id) {
        this.theater_id = theater_id;
    }
}
