package com.example.Book_My_Show_Appl.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("Shows")
public class ShowController {

    @PostMapping ("Add")
    public ResponseEntity addShows(@RequestBody )
}
