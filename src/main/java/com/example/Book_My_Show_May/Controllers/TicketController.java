package com.example.Book_My_Show_May.Controllers;

import com.example.Book_My_Show_May.EntryDtos.TicketEntryDto;
import com.example.Book_My_Show_May.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;
    @PostMapping("/book")
    public ResponseEntity  <String> bookTicket(@RequestBody TicketEntryDto ticketEntryDto){
        try{
            String result =ticketService.addTicket(ticketEntryDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Error booking ticket: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }


}
}
