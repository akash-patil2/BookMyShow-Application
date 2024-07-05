package com.example.Book_My_Show_Appl.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;
import java.time.LocalTime;

@Table
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Ticket {

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private String ticketId;

    private String movieName;

    private Integer bookedSeats;

    private LocalDate showDate;

    private LocalTime showTime;

    private Integer totalAmount;

    private String theaterName;

    @JoinColumn
    @ManyToOne
    private Show show;

    @JoinColumn
    @ManyToOne
    private User user;


}
