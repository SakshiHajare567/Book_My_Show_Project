package com.example.Book_My_Show_May.Controllers;

import com.example.Book_My_Show_May.EntryDtos.ShowEntryDto;
import com.example.Book_My_Show_May.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class ShowController {
    @Autowired
    ShowService showService ;

    @PostMapping("/add_show")
    public ResponseEntity<String> addShow(@RequestBody ShowEntryDto showEntryDto) {

        try {
            String result= showService.addShow(showEntryDto);
            return new ResponseEntity<>(result ,HttpStatus.CREATED);
        }
        catch (Exception e){
            String response="Error occurred while adding show";
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }

    }
}
