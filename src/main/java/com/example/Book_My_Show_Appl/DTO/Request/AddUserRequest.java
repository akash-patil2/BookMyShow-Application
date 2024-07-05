package com.example.Book_My_Show_Appl.DTO.Request;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AddUserRequest {

    private String name;

    private String emailId;

    private Integer age;

    private String mobileNo;
}
