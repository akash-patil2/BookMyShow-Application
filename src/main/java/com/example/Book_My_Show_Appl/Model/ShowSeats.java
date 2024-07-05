package com.example.Book_My_Show_Appl.Model;


import com.example.Book_My_Show_Appl.Enum.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Table
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

// ShowSeats are virtual representation of TheaterSeats

public class ShowSeats {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer showSeatsId;

    private String seatNumber;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private Boolean isBooked;

    private Boolean isFoodAttached;

    @JoinColumn
    @ManyToOne
    private Show show;
}
