package com.example.oopone.dto;

import com.example.oopone.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentUserDto {

    private String username;

    private String password;

    private int phonenumber;

    private String emailid;

    private double amt_to_add;
}