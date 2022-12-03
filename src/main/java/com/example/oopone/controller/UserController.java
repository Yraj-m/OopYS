package com.example.oopone.controller;


import com.example.oopone.model.Cart;
import com.example.oopone.model.Category;
import com.example.oopone.model.User;
import com.example.oopone.model.UserDto;
import com.example.oopone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/user/add")
    public User addUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping(value = "/users")
    public List<User> getUser(){
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
