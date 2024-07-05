package com.example.Book_My_Show_Appl.Repository;


import com.example.Book_My_Show_Appl.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository <Ticket, String> {

}
