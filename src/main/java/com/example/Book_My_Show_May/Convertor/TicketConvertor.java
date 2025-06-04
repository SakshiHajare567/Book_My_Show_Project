package com.example.Book_My_Show_May.Convertor;

import com.example.Book_My_Show_May.Entities.TicketEntity;
import com.example.Book_My_Show_May.EntryDtos.TicketEntryDto;

public class TicketConvertor {
    public static TicketEntity convertDtoToEntity(TicketEntryDto ticketEntryDto) {
        TicketEntity ticketEntity = new TicketEntity() ;
        // Do NOT set showId or userId directly — instead set actual entities in service layer
        // ticketEntity.setShowID(ticketEntryDto.getShowId()); ❌


       // ticketEntity.setTicketId(UUID.randomUUID().toString()); // always set this here
        // Do not set movieName, showDate, etc., here — let service do it // You can set other basic fields like timestamps or seat list string, if applicable
        return new TicketEntity();
    }
}


