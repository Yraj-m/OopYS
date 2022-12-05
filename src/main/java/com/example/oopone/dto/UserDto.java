package com.example.oopone.dto;


import com.example.oopone.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor@NoArgsConstructor@ToString
public class UserDto {

    private int id;

    private String username;

    private String password;

    private int phonenumber;

    private String emailid;

    private double wallet_amt;

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.phonenumber = user.getPhonenumber();
        this.emailid = user.getEmailid();
        this.wallet_amt = user.getWallet_amt();
    }
}
