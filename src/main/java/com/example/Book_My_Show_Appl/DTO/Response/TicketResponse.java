package com.example.Book_My_Show_Appl.DTO.Response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponse {

    private String movieName;

    private Integer bookedSeats;

    private LocalDate showDate;

    private LocalTime showTime;

    private Integer totalAmount;

    private String theaterName;

}
