package com.example.Book_My_Show_May.Service;

import com.example.Book_My_Show_May.Entities.*;
import com.example.Book_My_Show_May.EntryDtos.TicketEntryDto;
import com.example.Book_My_Show_May.Repository.ShowRepository;
import com.example.Book_My_Show_May.Repository.TicketRepository;
import com.example.Book_My_Show_May.Repository.UserRepository;
//import jdk.internal.icu.impl.BMPSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    ShowRepository showRepository ;
    @Autowired
    UserRepository userRepository;
    public  String addTicket (TicketEntryDto ticketEntryDto)throws Exception {

        //If check requestedSeat avaliable are not
        boolean isValidRequest = checkValidityOfRequestedSeat(ticketEntryDto);
        if (!isValidRequest) {
            throw new Exception("Request seat are not available");
        }
        //we assume that request seat are valid
        //calculate the total amount
        int showId = ticketEntryDto.getShowId();
        ShowEntity showEntity = showRepository.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show not found with ID: " + showId));

        //ShowEntity showEntity = showRepository.findById(showId).get();
        List<ShowSeatEntity> ListOfSeat = showEntity.getListOfShowSeats();
        List<String> requestSeat = ticketEntryDto.getRequestedSeats();
        int totalAmount = 0;
        Date bookingTime = new Date(); // current timestamp

        for (ShowSeatEntity showSeatEntity : ListOfSeat) {
            if (requestSeat.contains(showSeatEntity.getSeatNo())) {
                totalAmount += showSeatEntity.getPrice();

                showSeatEntity.setBooked(true);               // mark seat as booked
                showSeatEntity.setBookedAt(bookingTime);      // assuming this method exists
            }
        }
        TicketEntity ticketEntity = new TicketEntity();

        ticketEntity.setTotalAmount(totalAmount);
        ticketEntity.setMovieName(showEntity.getMovieEntity().getMovieName());
        ticketEntity.setShowDate(showEntity.getShowDate());
        ticketEntity.setShowTime(showEntity.getShowTime());
        ticketEntity.setTheaterName(showEntity.getTheaterEntity().getName());
       // ticketEntity.setTicketId(UUID.randomUUID().toString());

        // UUID and booked seats (in correct order)
       // ticketEntity.setTicketId(UUID.randomUUID().toString());
       // String allotedSeats = getAllotedSeatfromShowSeat(requestSeat);
       // ticketEntity.setBookedSeats(allotedSeats);


        //We need to set that string that taked about requestSeat
       String allotedSeats = getAllotedSeatfromShowSeat(requestSeat);
        ticketEntity.setBookedSeats(allotedSeats);
        //save the forgin
         /*UserEntity userEntity = userRepository.findById(ticketEntryDto.getUserId().get());
        int userId = ticketEntryDto.getUserId();
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        ticketEntity.setUserEntity(userEntity);
        ticketEntity.setShowEntity(showEntity);*/

        // Save the ticket first
       // ticketRepository.save(ticketEntity);
//Setting the foreign key attributes
        UserEntity userEntity = userRepository.findById(ticketEntryDto.getUserId()).get();

        ticketEntity.setUserEntity(userEntity);
        ticketEntity.setShowEntity(showEntity);

        //Save the parent
        ticketEntity = ticketRepository.save(ticketEntity);

        // Add ticket to show and user
        //showEntity.getListOfBookedTickets().add(ticketEntity);
       // userEntity.getBookedTickets().add(ticketEntity);
       // showRepository.save(showEntity);
       // userRepository.save(userEntity);

        //save the parent
        List<TicketEntity> ticketEntityList = showEntity.getListOfBookedTickets();
        ticketEntityList.add(ticketEntity);
        showEntity.setListOfBookedTickets(ticketEntityList);
        showRepository.save(showEntity);

        List<TicketEntity> ticketEntityList1 = userEntity.getBookedTickets();
        ticketEntityList1.add(ticketEntity);
        userEntity.setBookedTickets(ticketEntityList1);
        userRepository.save(userEntity);

        return "Ticket has been successfully added";

    }
    //private String getAllotedSeatfromShowSeat(List<ShowSeatEntity> requestSeats){
       // String result=" ";
        //for(String seat :requestSeat){
          //  result=result + seat+" ,";

       // }
        //return  result ;
        private String getAllotedSeatfromShowSeat(List<String> requestSeat) {
            String result = "";
            for (int i = 0; i < requestSeat.size(); i++) {
                result =result+ requestSeat.get(i);
                if (i != requestSeat.size() - 1) {
                    result += ", ";
                }
            }
            return result;
        }


    public boolean checkValidityOfRequestedSeat(TicketEntryDto ticketEntryDto){
       int showId = ticketEntryDto.getShowId();
       List<String> requestSeat = ticketEntryDto.getRequestedSeats();
       ShowEntity showEntity = showRepository.findById(showId).get();
       List<ShowSeatEntity>ListOfSeat=showEntity.getListOfShowSeats();
       //Iterating over the list of seats for that particular seat

        for (ShowSeatEntity showSeatEntity : ListOfSeat) {
            String seatNo = showSeatEntity.getSeatNo();
            if (requestSeat.contains(seatNo) && showSeatEntity.isBooked()) {
                return false;
            }
        }

        return true;

       }
}
