package com.example.Book_My_Show_Appl.Controller;


import com.example.Book_My_Show_Appl.DTO.Request.AddMovieRequest;
import com.example.Book_My_Show_Appl.DTO.Request.UpdateMovieRequest;
import com.example.Book_My_Show_Appl.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("Add")
    public ResponseEntity addMovie(@RequestBody AddMovieRequest movieRequest){

       String response = movieService.addMovie(movieRequest);
       return new ResponseEntity(response, HttpStatus.OK);
    }

    @PutMapping("Update")
    public ResponseEntity UpdateMovieAttributes(@RequestBody UpdateMovieRequest movieRequest){

        String response = movieService.updateMovieAttributes(movieRequest);

        return new ResponseEntity(response, HttpStatus.OK);
    }

}
