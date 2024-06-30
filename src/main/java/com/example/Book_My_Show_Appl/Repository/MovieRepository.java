package com.example.Book_My_Show_Appl.Repository;


import com.example.Book_My_Show_Appl.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {

    Movie findMovieByMovieName(String movieName);
}
