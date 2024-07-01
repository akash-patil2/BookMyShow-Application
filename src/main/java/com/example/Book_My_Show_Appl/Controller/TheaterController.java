package com.example.Book_My_Show_Appl.Controller;


import com.example.Book_My_Show_Appl.DTO.Request.AddTheaterRequest;
import com.example.Book_My_Show_Appl.DTO.Request.AddTheaterSeatsRequest;
import com.example.Book_My_Show_Appl.DTO.Request.UpdateMovieRequest;
import com.example.Book_My_Show_Appl.Repository.TheaterRepository;
import com.example.Book_My_Show_Appl.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("Theater")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @PostMapping("Add")
    public ResponseEntity addTheater(@RequestBody AddTheaterRequest theaterRequest){

        String response = theaterService.addTheater(theaterRequest);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PutMapping("AssociateSeats")
    public ResponseEntity associateSeats(@RequestBody AddTheaterSeatsRequest theaterSeatsRequest){

        String response = theaterService.associateTheaterSeats(theaterSeatsRequest);

        return new ResponseEntity(response, HttpStatus.OK);
    }

}
