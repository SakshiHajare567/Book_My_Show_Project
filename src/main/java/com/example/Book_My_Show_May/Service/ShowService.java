package com.example.Book_My_Show_May.Service;

import com.example.Book_My_Show_May.Convertor.ShowConvertor;
import com.example.Book_My_Show_May.Entities.*;
import com.example.Book_My_Show_May.EntryDtos.ShowEntryDto;
import com.example.Book_My_Show_May.Enums.SeatType;
import com.example.Book_My_Show_May.Repository.MovieRepository;
import com.example.Book_My_Show_May.Repository.ShowRepository;
import com.example.Book_My_Show_May.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheaterRepository theaterRepository ;

    @Autowired
    ShowRepository showRepository ;
    public  String addShow (ShowEntryDto showEntryDto)throws Exception{
        ShowEntity showEntity= ShowConvertor.convertDtoToEntity(showEntryDto );

        int movieId=showEntryDto.getMovie_id();
        int theaterId=showEntryDto.getTheater_id();

        // Fetch movie and theater entities
        MovieEntity movieEntity = movieRepository.findById(movieId).get();
        TheaterEntity theaterEntity = theaterRepository.findById(theaterId).get();


        // Set movie and theater to the show
        showEntity.setMovieEntity(movieEntity);
        showEntity.setTheaterEntity(theaterEntity);

        //To create a showseatEntity
        List<ShowSeatEntity>showSeatEntityList=createShowSeatEntity(showEntryDto ,showEntity);

        List<ShowEntity>showEntityList=movieEntity.getShowEntityList();
        showEntityList.add(showEntity);
        movieEntity.setShowEntityList(showEntityList);
        movieRepository.save(movieEntity);

        List<ShowEntity>showEntityList1=theaterEntity.getShowEntityList();
        showEntityList1.add(showEntity);
        theaterEntity.setShowEntityList(showEntityList1);
        theaterRepository.save(theaterEntity);
        return "show has been added successfully";
    }
    public List<ShowSeatEntity> createShowSeatEntity(ShowEntryDto showEntryDto, ShowEntity showEntity) {

        TheaterEntity theaterEntity = showEntity.getTheaterEntity();

        List<TheaterSeatEntity> theaterSeatEntityList = theaterEntity.getTheaterSeatEntityList();


        List<ShowSeatEntity> seatEntityList = new ArrayList<>();

        for (TheaterSeatEntity theaterSeatEntity : theaterSeatEntityList) {

            ShowSeatEntity showSeatEntity = new ShowSeatEntity();

            showSeatEntity.setSeatNo(theaterSeatEntity.getSeatNo());
            showSeatEntity.setSeatType(theaterSeatEntity.getSeatType());
            if (theaterSeatEntity.getSeatType().equals(SeatType.CLASSIC)) {
                showSeatEntity.setPrice(showEntryDto.getClassicSeatPrice());
            } else {
                showSeatEntity.setPrice(showEntryDto.getPremiumSeatPrice());
            }

            showSeatEntity.setBooked(false);
            showSeatEntity.setShowEntity(showEntity);
            seatEntityList.add(showSeatEntity);

        }
        return seatEntityList;


    }

}
