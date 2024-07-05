package com.example.Book_My_Show_Appl.Controller;


import com.example.Book_My_Show_Appl.DTO.Request.BookTicketRequest;
import com.example.Book_My_Show_Appl.Model.Ticket;
import com.example.Book_My_Show_Appl.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("Ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping ("bookTicket")

    public Ticket bookTicket(@RequestBody BookTicketRequest bookTicketRequest){

    }
}
