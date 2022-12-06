package com.example.oopone.controller;

import com.example.oopone.dto.UserDto;
import com.example.oopone.model.User;
import com.example.oopone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@CrossOrigin
@RestController
public class LoginController {

    @Autowired
    UserService userService;

    //checking if user exists
    @PostMapping("/login")
    public UserDto login(@RequestBody HashMap<String, String> login) {
        if (userService.getUserByUsername(login.get("username")).getPassword().equals(login.get("password"))) {
            return userService.getUserByUsername(login.get("username"));
        }
        return null;
    }

    @PostMapping("/admin/login")
    public String adminLogin(@RequestBody HashMap<String, String> login) {
        String adminPass = "1234";
        if (login.get("password").equals(adminPass)) return adminPass;
        else return null;
    }
}
