package com.example.Book_My_Show_Appl.Model;


import com.example.Book_My_Show_Appl.Enum.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ShowSeats {

    private Integer seatNumber;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private Boolean isAvailable;
}
