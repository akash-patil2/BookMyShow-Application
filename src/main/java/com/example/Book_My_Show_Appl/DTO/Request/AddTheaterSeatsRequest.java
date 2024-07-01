package com.example.Book_My_Show_Appl.DTO.Request;


import com.example.Book_My_Show_Appl.Enum.SeatType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class AddTheaterSeatsRequest {

    private Integer theaterId;

    private Integer noOfClassicSeats;

    private Integer noOfPremiumSeats;

}
