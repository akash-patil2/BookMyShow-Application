package com.example.Book_My_Show_Appl.DTO.Request;


import lombok.Data;

@Data
public class AddTheaterRequest {

    private String address;

    private String theaterName;

    private Integer noOfScreens;
}
