package com.example.Book_My_Show_Appl.Repository;


import com.example.Book_My_Show_Appl.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
