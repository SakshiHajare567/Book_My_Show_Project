package com.example.Book_My_Show_May.Controllers;

import com.example.Book_My_Show_May.EntryDtos.MovieEntryDto;
import com.example.Book_My_Show_May.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
   private MovieService movieService ;

    @PostMapping("/add")
public ResponseEntity<String>addMovie(@RequestBody MovieEntryDto movieEntryDto){
        try{
            String result = movieService.addMovie(movieEntryDto);
            return new ResponseEntity<>(result , HttpStatus.CREATED);

        }
        catch (Exception e){
            String response = "movie could not added";
            return  new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);

        }


    }
}

