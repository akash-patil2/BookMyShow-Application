package com.example.Book_My_Show_Appl.DTO.Request;

import com.example.Book_My_Show_Appl.Enum.Language;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateMovieRequest {

    private String movieName;

    private Language newLanguage;

    private Double newRating;
}
