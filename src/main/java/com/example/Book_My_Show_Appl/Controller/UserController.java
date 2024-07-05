package com.example.Book_My_Show_Appl.Controller;

import com.example.Book_My_Show_Appl.DTO.Request.AddUserRequest;
import com.example.Book_My_Show_Appl.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("User")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping ("addUser")
    public String addUser(@RequestBody AddUserRequest addUserRequest){

        return userService.addUser(addUserRequest);
    }
}
