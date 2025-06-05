package com.example.Book_My_Show_May.EntryDtos;

import com.example.Book_My_Show_May.Enums.Genre;
import com.example.Book_My_Show_May.Enums.Language;
//import jakarta.persistence.Column;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;

public class MovieEntryDto {

    private String movieName ;
    private  double rating ;
    private int duration ;
    private Genre genre;
    private Language language ;

    public MovieEntryDto() {
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
