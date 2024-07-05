package com.example.Book_My_Show_Appl.Service;


import com.example.Book_My_Show_Appl.DTO.Request.AddUserRequest;
import com.example.Book_My_Show_Appl.Model.User;
import com.example.Book_My_Show_Appl.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String addUser(AddUserRequest addUserRequest){

        User user = User.builder().age(addUserRequest.getAge())
                .name(addUserRequest.getName())
                .emailId(addUserRequest.getEmailId())
                .mobileNo(addUserRequest.getMobileNo())
                .build();

        user = userRepository.save(user);

        return "User has been saved to the DB with userId " + user.getUserId();
    }
}
