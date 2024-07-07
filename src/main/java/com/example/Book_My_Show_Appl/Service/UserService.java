package com.example.Book_My_Show_Appl.Service;


import com.example.Book_My_Show_Appl.DTO.Request.AddUserRequest;
import com.example.Book_My_Show_Appl.Model.User;
import com.example.Book_My_Show_Appl.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    JavaMailSender javaMailSender;

    public String addUser(AddUserRequest addUserRequest){

        User user = User.builder().age(addUserRequest.getAge())
                .name(addUserRequest.getName())
                .emailId(addUserRequest.getEmailId())
                .mobileNo(addUserRequest.getMobileNo())
                .build();

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(addUserRequest.getEmailId());
        mailMessage.setFrom("rideitis3@gmail.com");
        mailMessage.setSubject("Welcome to Book My Show!!");

        String body = "Hi " + addUserRequest.getName() + " !" + "Welcome to Book My Show, Use WELCOME10 to get 10% off on tickets";

        mailMessage.setText(body);

        javaMailSender.send(mailMessage);

        user = userRepository.save(user);



        return "User has been saved to the DB with userId " + user.getUserId();
    }
}
