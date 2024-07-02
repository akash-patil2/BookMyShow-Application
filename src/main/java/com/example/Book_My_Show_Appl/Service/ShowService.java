package com.example.Book_My_Show_Appl.Service;


import com.example.Book_My_Show_Appl.DTO.Request.AddShowRequest;
import com.example.Book_My_Show_Appl.Model.*;
import com.example.Book_My_Show_Appl.Repository.MovieRepository;
import com.example.Book_My_Show_Appl.Repository.ShowRepository;
import com.example.Book_My_Show_Appl.Repository.ShowSeatsRepository;
import com.example.Book_My_Show_Appl.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ShowSeatsRepository showSeatsRepository;

    public String addShows(AddShowRequest addShowRequest){

        Movie movie = movieRepository.findMovieByMovieName(addShowRequest.getMovieName());

        Theater theater = theaterRepository.findById(addShowRequest.getTheaterId()).get();

        Show show = Show.builder().showDate(addShowRequest.getShowDate())
                .showTime(addShowRequest.getShowTime())
                .movie(movie)
                .theater(theater)
                .build();

        show = showRepository.save(show);

        //Associating showSeats with show
        List<TheaterSeats> theaterSeatsList = theater.getTheaterSeatsList();

        List<ShowSeats> showSeatsList = new ArrayList<>();

        for(TheaterSeats theaterSeats:theaterSeatsList){

            ShowSeats showSeats = ShowSeats.builder().seatNumber(theaterSeats.getSeatNumber())
                    .seatType(theaterSeats.getSeatType())
                    .isBooked(Boolean.FALSE)
                    .isFoodAttached(Boolean.FALSE)
                    .show(show).build();
            showSeatsList.add(showSeats);
        }

        showSeatsRepository.saveAll(showSeatsList);

        return "The Show has been saved to the DB with showId " + show.getShowId();
    }


}
