package com.example.Book_My_Show_May.Service;

import com.example.Book_My_Show_May.Entities.*;
import com.example.Book_My_Show_May.EntryDtos.TicketEntryDto;
import com.example.Book_My_Show_May.Repository.ShowRepository;
import com.example.Book_My_Show_May.Repository.TicketRepository;
import com.example.Book_My_Show_May.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    JavaMailSender javaMailSender;

    public String addTicket(TicketEntryDto ticketEntryDto) throws Exception {

        // 1. Validate requested seats
        if (!checkValidityOfRequestedSeat(ticketEntryDto)) {
            throw new Exception("Requested seats are not available");
        }

        // 2. Fetch ShowEntity
        int showId = ticketEntryDto.getShowId();
        ShowEntity showEntity = showRepository.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show not found with ID: " + showId));

        List<ShowSeatEntity> seatList = showEntity.getListOfShowSeats();
        List<String> requestedSeats = ticketEntryDto.getRequestedSeats();

        // 3. Calculate total amount and mark seats as booked
        int totalAmount = 0;
        LocalDateTime bookingTime = LocalDateTime.now();  // ✅ Fixed type

        for (ShowSeatEntity seat : seatList) {
            if (requestedSeats.contains(seat.getSeatNo())) {
                totalAmount += seat.getPrice();
                seat.setBooked(true);
                seat.setBookedAt(bookingTime); // ✅ No type error now
            }
        }

        // 4. Create and fill TicketEntity
        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setTicketId(UUID.randomUUID().toString());
        ticketEntity.setTotalAmount(totalAmount);
        ticketEntity.setBookedSeats(String.join(", ", requestedSeats));
        ticketEntity.setMovieName(showEntity.getMovieEntity().getMovieName());
        ticketEntity.setShowDate(showEntity.getShowDate());
        ticketEntity.setShowTime(showEntity.getShowTime());
        ticketEntity.setTheaterName(showEntity.getTheaterEntity().getName());

        // 5. Fetch UserEntity and set relationships
        UserEntity userEntity = userRepository.findById(ticketEntryDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + ticketEntryDto.getUserId()));

        ticketEntity.setUserEntity(userEntity);
        ticketEntity.setShowEntity(showEntity);

        // 6. Save ticket
        ticketEntity = ticketRepository.save(ticketEntity);

        // 7. Update parent ShowEntity
        showEntity.getListOfBookedTickets().add(ticketEntity);
        showRepository.save(showEntity);

        // 8. Update parent UserEntity
        userEntity.getBookedTickets().add(ticketEntity);
        userRepository.save(userEntity);


//        String body = "Hi this is to confirm your booking for seat No "+allotedSeats +"for the movie : " + ticketEntity.getMovieName();
//
//
//        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
//        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
//        mimeMessageHelper.setFrom("backeendacciojob@gmail.com");
//        mimeMessageHelper.setTo(userEntity.getEmail());
//        mimeMessageHelper.setText(body);
//        mimeMessageHelper.setSubject("Confirming your booked Ticket");
//
//        javaMailSender.send(mimeMessage);


        return "Ticket has been successfully added";
    }

    // ✅ Validate requested seats are not already booked
    public boolean checkValidityOfRequestedSeat(TicketEntryDto ticketEntryDto) {
        int showId = ticketEntryDto.getShowId();
        List<String> requestedSeats = ticketEntryDto.getRequestedSeats();

        ShowEntity showEntity = showRepository.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show not found"));

        for (ShowSeatEntity seat : showEntity.getListOfShowSeats()) {
            if (requestedSeats.contains(seat.getSeatNo()) && seat.isBooked()) {
                return false;
            }
        }

        return true;
    }
}
