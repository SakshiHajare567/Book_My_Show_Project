package com.example.Book_My_Show_May.Convertor;

import com.example.Book_My_Show_May.Entities.MovieEntity;
import com.example.Book_My_Show_May.EntryDtos.MovieEntryDto;

public class MovieConvertor {

    public static MovieEntity convertDtoToEntity(MovieEntryDto movieEntryDto){
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setMovieName(movieEntryDto.getMovieName());
        movieEntity.setDuration(movieEntryDto.getDuration());
        movieEntity.setGenre(movieEntryDto.getGenre());
        movieEntity.setRating(movieEntryDto.getRating());      // ✅ Corrected
        movieEntity.setLanguage(movieEntryDto.getLanguage());  // ✅ Corrected
        return movieEntity;
    }

}
