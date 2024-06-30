package com.example.Book_My_Show_Appl.Model;


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

public class Theater {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer theaterId;

    private String address;

    private String theaterName;

    private Integer noOfScreens;


}
