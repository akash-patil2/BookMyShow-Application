package com.example.Book_My_Show_Appl.Controller;


import com.example.Book_My_Show_Appl.DTO.Request.BookTicketRequest;
import com.example.Book_My_Show_Appl.DTO.Response.TicketResponse;
import com.example.Book_My_Show_Appl.Model.Ticket;
import com.example.Book_My_Show_Appl.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("Ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping ("bookTicket")

    public String bookTicket(@RequestBody BookTicketRequest bookTicketRequest){

        return ticketService.addTicket(bookTicketRequest);
    }

    @GetMapping("GenerateTicket")
    public TicketResponse generateTicket(@RequestParam("ticketId") String ticketId){
        return ticketService.generateTicket(ticketId);
    }
}
