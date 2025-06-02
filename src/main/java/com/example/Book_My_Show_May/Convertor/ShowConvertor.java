package com.example.Book_My_Show_May.Convertor;

import com.example.Book_My_Show_May.Entities.ShowEntity;
import com.example.Book_My_Show_May.EntryDtos.ShowEntryDto;

public class ShowConvertor {
    public static ShowEntity convertDtoToEntity (ShowEntryDto showEntryDto){
        ShowEntity showEntity = new ShowEntity();
        showEntity.setShowTime(showEntryDto.getShowTime());
        showEntity.setShowType(showEntryDto.getShowType());
        showEntity.setShowDate(showEntryDto.getShowDate());
        return showEntity;
    }
}
