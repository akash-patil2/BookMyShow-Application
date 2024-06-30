package com.example.Book_My_Show_Appl.Service;


import com.example.Book_My_Show_Appl.DTO.Request.AddMovieRequest;
import com.example.Book_My_Show_Appl.DTO.Request.UpdateMovieRequest;
import com.example.Book_My_Show_Appl.Model.Movie;
import com.example.Book_My_Show_Appl.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public String addMovie(AddMovieRequest movieRequest){

        Movie movie = new Movie();
        movie.setMovieName(movieRequest.getMovieName());
        movie.setDuration(movieRequest.getDuration());
        movie.setLanguage(movieRequest.getLanguage());
        movie.setRating(movieRequest.getRating());
        movie.setReleaseDate(movieRequest.getReleaseDate());

        movie = movieRepository.save(movie);
        return "Movie has been added to the DB with movieID " + movie.getMovieId();
    }

    public String updateMovieAttributes(UpdateMovieRequest movieRequest){

        // getting the Movie entity
        Movie movie = movieRepository.findMovieByMovieName(movieRequest.getMovieName());

        // updating the attributes
        movie.setLanguage(movieRequest.getNewLanguage());
        movie.setRating(movieRequest.getNewRating());

        // Saving the Movie Entity into DB
        movieRepository.save(movie);

        return "Movie attributes have been updated ";

    }
}
