package com.example.Book_My_Show_Appl.DTO.Request;


import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AddShowRequest {

    private LocalTime showTime;

    private LocalDate showDate;

}
