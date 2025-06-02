package com.example.Book_My_Show_May.Convertor;

import com.example.Book_My_Show_May.Entities.TheaterEntity;
import com.example.Book_My_Show_May.EntryDtos.TheaterEntryDto;

public class TheaterConvertor {
    public static TheaterEntity convertDtoToEntity(TheaterEntryDto theaterEntryDto){
        TheaterEntity theaterEntity =new TheaterEntity();
        theaterEntity.setName(theaterEntryDto.getName());
        theaterEntity.setLocation(theaterEntryDto.getLocation());
        return theaterEntity;
    }
}
