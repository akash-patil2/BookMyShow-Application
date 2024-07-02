package com.example.Book_My_Show_Appl.Controller;


import com.example.Book_My_Show_Appl.DTO.Request.AddShowRequest;
import com.example.Book_My_Show_Appl.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("Shows")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping ("Add")
    public ResponseEntity addShows(@RequestBody AddShowRequest addShowRequest){

        String response = showService.addShows(addShowRequest);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
