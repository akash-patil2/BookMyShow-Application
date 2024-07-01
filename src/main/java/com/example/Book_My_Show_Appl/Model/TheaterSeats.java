package com.example.Book_My_Show_Appl.Model;


import com.example.Book_My_Show_Appl.Enum.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class TheaterSeats {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer theaterId;

    private Integer seatNumber;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    @JoinColumn
    @ManyToOne
    private Theater theater;

}
