package com.example.Book_My_Show_Appl.Service;

import com.example.Book_My_Show_Appl.DTO.Request.AddTheaterRequest;
import com.example.Book_My_Show_Appl.DTO.Request.UpdateMovieRequest;
import com.example.Book_My_Show_Appl.Model.Theater;
import com.example.Book_My_Show_Appl.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    public String addTheater(AddTheaterRequest theaterRequest){

        // Creation of object using Builder
        Theater theater = Theater.builder().noOfScreens(theaterRequest.getNoOfScreens())
                .theaterName(theaterRequest.getTheaterName())
                .address(theaterRequest.getAddress())
                .build();

        theater = theaterRepository.save(theater);
        return "Theater has been saved to the DB with theaterId " + theater.getTheaterId();
    }

}
