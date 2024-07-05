package com.example.Book_My_Show_Appl.DTO.Request;


import com.example.Book_My_Show_Appl.Model.Theater;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class BookTicketRequest {

//    private String movieName;
//
//    private LocalDate showDate;
//
//    private LocalTime showTime;
//
//    private Integer theaterId;

    private Integer showId;

    private Integer userId;

    private List<String> requestedSeats;


}
