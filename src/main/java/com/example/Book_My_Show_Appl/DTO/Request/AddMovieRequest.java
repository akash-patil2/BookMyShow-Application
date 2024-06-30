package com.example.Book_My_Show_Appl.DTO.Request;


import com.example.Book_My_Show_Appl.Enum.Language;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AddMovieRequest {

    private String movieName;

    private Double duration;

    private LocalDate releaseDate;

    private Language language;

    private Double rating;
}
