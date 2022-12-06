package com.example.oopone.controller;



import com.example.oopone.model.User;
import com.example.oopone.dto.UserDto;
import com.example.oopone.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/user/add")
    public User addUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping(value = "/users")
    public List<UserDto> getUser(){
        return userService.getUsers();
    }

    @GetMapping(value = "/user/{id}")
    public UserDto getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

//    @GetMapping(value = "/user/cart/{id}")
//    public List<Cart> getCartsFromUser(@PathVariable int id){
//        return userService.getUserCart(id);
//    }

}
