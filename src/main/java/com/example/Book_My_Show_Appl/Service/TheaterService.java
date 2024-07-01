package com.example.Book_My_Show_Appl.Service;

import com.example.Book_My_Show_Appl.DTO.Request.AddTheaterRequest;
import com.example.Book_My_Show_Appl.DTO.Request.AddTheaterSeatsRequest;
import com.example.Book_My_Show_Appl.DTO.Request.UpdateMovieRequest;
import com.example.Book_My_Show_Appl.Enum.SeatType;
import com.example.Book_My_Show_Appl.Model.Theater;
import com.example.Book_My_Show_Appl.Model.TheaterSeats;
import com.example.Book_My_Show_Appl.Repository.TheaterRepository;
import com.example.Book_My_Show_Appl.Repository.TheaterSeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private TheaterSeatsRepository theaterSeatsRepository;

    public String addTheater(AddTheaterRequest theaterRequest){

        // Creation of object using Builder
        Theater theater = Theater.builder().noOfScreens(theaterRequest.getNoOfScreens())
                .theaterName(theaterRequest.getTheaterName())
                .address(theaterRequest.getAddress())
                .build();

        theater = theaterRepository.save(theater);
        return "Theater has been saved to the DB with theaterId " + theater.getTheaterId();
    }

    public String associateTheaterSeats(AddTheaterSeatsRequest theaterSeatsRequest){

        int theaterId = theaterSeatsRequest.getTheaterId();
        int noOfClassicSeats = theaterSeatsRequest.getNoOfClassicSeats();
        int noOfPremiumSeats = theaterSeatsRequest.getNoOfPremiumSeats();

        List<TheaterSeats> theaterSeatsList = new ArrayList<>();

        // Get the Theater entity from DB
        Theater theater = theaterRepository.findById(theaterId).get();

        // Generating seatNos For Classic seats
        int noOfRowsOfClassicSeats = noOfClassicSeats / 5;
        int noOfSeatsInLastRowClassic = noOfClassicSeats % 5;

        int row;
        for(row = 1; row <= noOfRowsOfClassicSeats; row++){

            for(int j = 1; j <= 5; j++){

                char ch = (char) ('A' + j -1);
                String seatNo = "" + row + ch;

                TheaterSeats theaterSeats = TheaterSeats.builder().seatNumber(seatNo)
                        .seatType(SeatType.CLASSIC)
                        .theater(theater)
                        .build();

                theaterSeatsList.add(theaterSeats);
            }
        }

        // for the last row
        for(int j = 1; j <= noOfSeatsInLastRowClassic; j++){
            char ch = (char) ('A' + j -1);
            String seatNo = "" + row + ch;

            TheaterSeats theaterSeats = TheaterSeats.builder().seatNumber(seatNo)
                    .seatType(SeatType.CLASSIC)
                    .theater(theater)
                    .build();

            theaterSeatsList.add(theaterSeats);
        }

        // Generating seatNos for Premium seats
        int noOfRowsOfPremiumSeats = noOfPremiumSeats / 5;
        int noOfSeatsInLastRowPremium = noOfPremiumSeats % 5;

        int currentRow = row;
        if(noOfSeatsInLastRowClassic > 0){
            currentRow++;
        }

        for(row = currentRow; row <= noOfRowsOfPremiumSeats + currentRow - 1; row++){

            for(int j = 1; j <= 5; j++){

                char ch = (char) ('A' + j -1);
                String seatNo = "" + row + ch;

                TheaterSeats theaterSeats = TheaterSeats.builder().seatNumber(seatNo)
                        .seatType(SeatType.PREMIUM)
                        .theater(theater)
                        .build();

                theaterSeatsList.add(theaterSeats);
            }
        }

        // for the last row
        for(int j = 1; j <= noOfSeatsInLastRowPremium; j++){
            char ch = (char) ('A' + j -1);
            String seatNo = "" + row + ch;

            TheaterSeats theaterSeats = TheaterSeats.builder().seatNumber(seatNo)
                    .seatType(SeatType.PREMIUM)
                    .theater(theater)
                    .build();

            theaterSeatsList.add(theaterSeats);
        }


        // Saving all the generated Theater seats into the DB
        theaterSeatsRepository.saveAll(theaterSeatsList);
        return "the Theater seats have been associated";

    }

}
