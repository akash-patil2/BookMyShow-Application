package com.example.Book_My_Show_Appl.Controller;


import com.example.Book_My_Show_Appl.DTO.Request.AddTheaterRequest;
import com.example.Book_My_Show_Appl.DTO.Request.UpdateMovieRequest;
import com.example.Book_My_Show_Appl.Repository.TheaterRepository;
import com.example.Book_My_Show_Appl.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
