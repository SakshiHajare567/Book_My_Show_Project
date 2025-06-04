/*package com.example.Book_My_Show_May.Service;

import com.example.Book_My_Show_May.Convertor.TheaterConvertor;
import com.example.Book_My_Show_May.Entities.TheaterEntity;
import com.example.Book_My_Show_May.Entities.TheaterSeatEntity;
import com.example.Book_My_Show_May.EntryDtos.TheaterEntryDto;
import com.example.Book_My_Show_May.Enums.SeatType;
import com.example.Book_My_Show_May.Repository.TheaterRepository;
import com.example.Book_My_Show_May.Repository.TheaterSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    TheaterSeatRepository theaterSeatRepository;

    @Autowired
    TheaterRepository theaterRepository ;

    public String addTheater(TheaterEntryDto theaterEntryDto)throws Exception {

        if(theaterEntryDto.getName()==null || theaterEntryDto.getLocation()==null){
            throw new  Exception ("Name and location theater is invalid");
        }
        TheaterEntity theaterEntity = TheaterConvertor.convertDtoToEntity(theaterEntryDto);
        List<TheaterSeatEntity> theaterSeatEntityList = createTheaterSeats(theaterEntryDto, theaterEntity);
        theaterEntity.setTheaterSeatEntityList(theaterSeatEntityList);
        theaterRepository.save(theaterEntity);
        // save theaterEntity if you have a repository (not shown here)
        return "Theater and seats added successfully!";
        // Save seats
      //  theaterSeatRepository.saveAll(theaterSeatEntityList);

        // Set seats to theater and return success

    }

    public List<TheaterSeatEntity> createTheaterSeats(TheaterEntryDto theaterEntryDto, TheaterEntity theaterEntity) {
        //List<TheaterSeatEntity> seats = new ArrayList<>();

        int noClassicSeat = theaterEntryDto.getClassicSetsCount();
        int noPremiumSeat = theaterEntryDto.getPremiumSetsCount();

        List<TheaterSeatEntity> theaterSeatEntityList = new ArrayList<>();

        // Create classic seats
        for (int count = 1; count <= noClassicSeat; count++) {
            TheaterSeatEntity theaterSeatEntity = new TheaterSeatEntity();
            theaterSeatEntity.setSeatType(SeatType.CLASSIC);
            theaterSeatEntity.setSeatNo(count + "C");
            theaterSeatEntity.setTheaterEntity(theaterEntity);

            theaterSeatEntityList.add(theaterSeatEntity);
        }

        // Create premium seats
        for (int count = 1; count <= noPremiumSeat; count++) {
            TheaterSeatEntity theaterSeatEntity = new TheaterSeatEntity();
            theaterSeatEntity.setSeatType(SeatType.PREMIUM);
            theaterSeatEntity.setSeatNo(count + "P");
            theaterSeatEntity.setTheaterEntity(theaterEntity);

            theaterSeatEntityList.add(theaterSeatEntity);
        }

        return theaterSeatEntityList;
    }
}*/

package com.example.Book_My_Show_May.Service;

import com.example.Book_My_Show_May.Convertor.TheaterConvertor;
import com.example.Book_My_Show_May.Entities.TheaterEntity;
import com.example.Book_My_Show_May.Entities.TheaterSeatEntity;
import com.example.Book_My_Show_May.EntryDtos.TheaterEntryDto;
import com.example.Book_My_Show_May.Enums.SeatType;
import com.example.Book_My_Show_May.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    public String addTheater(TheaterEntryDto theaterEntryDto) throws Exception {

        if (theaterEntryDto.getName() == null || theaterEntryDto.getLocation() == null) {
            throw new Exception("Name and location of theater are required");
        }

        // Convert DTO to Entity
        TheaterEntity theaterEntity = TheaterConvertor.convertDtoToEntity(theaterEntryDto);

        // Create seats and set parent
        List<TheaterSeatEntity> theaterSeats = createTheaterSeats(theaterEntity, theaterEntryDto);

        // Set child seats to parent
        theaterEntity.setTheaterSeatEntityList(theaterSeats);

        // Save only parent — seats will be auto-saved due to cascade
        theaterRepository.save(theaterEntity);

        return "Theater and seats added successfully!";
    }

    private List<TheaterSeatEntity> createTheaterSeats(TheaterEntity theaterEntity, TheaterEntryDto theaterEntryDto) {
        List<TheaterSeatEntity> seats = new ArrayList<>();

        for (int i = 1; i <= theaterEntryDto.getClassicSetsCount(); i++) {
            TheaterSeatEntity seat = new TheaterSeatEntity();
            seat.setSeatNo(i + "C");
            seat.setSeatType(SeatType.CLASSIC);
            seat.setTheaterEntity(theaterEntity); // Set parent
            seats.add(seat);
        }

        for (int i = 1; i <= theaterEntryDto.getPremiumSetsCount(); i++) {
            TheaterSeatEntity seat = new TheaterSeatEntity();
            seat.setSeatNo(i + "P");
            seat.setSeatType(SeatType.PREMIUM);
            seat.setTheaterEntity(theaterEntity); // Set parent
            seats.add(seat);
        }

        return seats;
    }
}

