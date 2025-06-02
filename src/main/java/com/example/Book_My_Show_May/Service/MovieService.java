package com.example.Book_My_Show_May.Service;

import com.example.Book_My_Show_May.Convertor.MovieConvertor;
import com.example.Book_My_Show_May.Entities.MovieEntity;
import com.example.Book_My_Show_May.EntryDtos.MovieEntryDto;
import com.example.Book_My_Show_May.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
@Autowired
    MovieRepository movieRepository ;
    public String addMovie(MovieEntryDto movieEntryDto)throws Exception{
        MovieEntity movieEntity = MovieConvertor.convertDtoToEntity(movieEntryDto);
        movieRepository.save(movieEntity);
        return "Movie added successfully";

    }
}
