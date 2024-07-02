package com.example.Book_My_Show_Appl.Repository;


import com.example.Book_My_Show_Appl.Model.ShowSeats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatsRepository extends JpaRepository <ShowSeats, Integer> {
}
