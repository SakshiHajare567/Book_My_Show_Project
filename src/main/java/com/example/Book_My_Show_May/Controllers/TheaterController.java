package com.example.Book_My_Show_May.Controllers;

import com.example.Book_My_Show_May.EntryDtos.TheaterEntryDto;
import com.example.Book_My_Show_May.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theaters")
public class TheaterController {
    @Autowired
    TheaterService theaterService ;
    @PostMapping("/add")
    public ResponseEntity <String> addTheater (@RequestBody TheaterEntryDto theaterEntryDto){
        try{
            String result =  theaterService.addTheater(theaterEntryDto);
            return  new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        catch (Exception e){
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

}
