package com.example.Book_My_Show_May.EntryDtos;

import java.util.ArrayList;
import java.util.List;

public class TicketEntryDto {
    private int showId;
    private int userId;
    private List<String> requestedSeats;
    public TicketEntryDto() {
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<String> getRequestedSeats() {
        return requestedSeats;
    }

    public void setRequestedSeats(List<String> requestedSeats) {
        this.requestedSeats = requestedSeats;
    }
}
