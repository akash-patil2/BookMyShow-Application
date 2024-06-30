package com.example.Book_My_Show_Appl.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Ticket {

    private String movieName;

    private Integer seatBooked;

    private LocalDate date;

    private LocalTime time;

    private Double totalAmount;

}
