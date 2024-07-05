package com.example.Book_My_Show_Appl.Service;

import com.example.Book_My_Show_Appl.DTO.Request.BookTicketRequest;
import com.example.Book_My_Show_Appl.Enum.SeatType;
import com.example.Book_My_Show_Appl.Model.Show;
import com.example.Book_My_Show_Appl.Model.ShowSeats;
import com.example.Book_My_Show_Appl.Model.Ticket;
import com.example.Book_My_Show_Appl.Model.User;
import com.example.Book_My_Show_Appl.Repository.ShowRepository;
import com.example.Book_My_Show_Appl.Repository.ShowSeatsRepository;
import com.example.Book_My_Show_Appl.Repository.TicketRepository;
import com.example.Book_My_Show_Appl.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ShowSeatsRepository showSeatsRepository;

    @Autowired
    private UserRepository userRepository;

    public Ticket addTicket(BookTicketRequest bookTicketRequest){

        // Find the Show entity
        Show show = showRepository.findById(bookTicketRequest.getShowId()).get();

        // Find the User entity
        User user = userRepository.findById(bookTicketRequest.getUserId()).get();

        // Mark those seat as booked now & calculate total amount
        Integer totalAmount = 0;
        List<ShowSeats> showSeatsList = show.getShowSeatsList();

        for(ShowSeats showSeats: showSeatsList){
            String seatNo = showSeats.getSeatNumber();

            if(bookTicketRequest.getRequestedSeats().contains(seatNo)){
                showSeats.setIsBooked(Boolean.TRUE);

                if(showSeats.getSeatType().equals(SeatType.CLASSIC)){
                    totalAmount = totalAmount + 100;
                }
                else{
                    totalAmount = totalAmount + 150;
                }
            }
        }

        // Create the Ticket entity & set all the attributes
        Ticket ticket = Ticket.builder().showDate(show.getShowDate())
                .showTime(show.getShowTime())
                .movieName(show.getMovie().getMovieName())
                .theaterName(show.getTheater().getTheaterName())
                .totalAmount(totalAmount)
                .show(show)
                .user(user)
                .build();

        showSeatsRepository.saveAll(showSeatsList);


        // Save the Ticket into DB & return Ticket entity (Ticket response)
        ticket = ticketRepository.save(ticket);
        return ticket;
    }
}
