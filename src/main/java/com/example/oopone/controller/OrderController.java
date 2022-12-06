package com.example.oopone.controller;

import com.example.oopone.dto.OrderDto;
import com.example.oopone.dto.UserDto;
import com.example.oopone.model.Orders;
import com.example.oopone.service.CartItemsService;
import com.example.oopone.service.OrderService;
import com.example.oopone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
public class OrderController {

    @Autowired
    CartItemsService cartItemsService;

    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;


    @DeleteMapping("/order/{userid}")
    public void order(@RequestHeader HashMap<String, String> header, @PathVariable int userid){
        UserDto user = userService.getUserById(userid);
        if(user.getPassword().equals(header.get("token"))) cartItemsService.deleteAllItemsFromCart(userid);
    }

    @PostMapping("/addOrder/{userid}")
    public String addOrderedProductsInCart(@RequestHeader HashMap<String, String> header, @PathVariable int userid){
        UserDto user = userService.getUserById(userid);
        if(user.getPassword().equals(header.get("token"))) return orderService.addOrderedProducts(userid);
        else return null;
    }

    @GetMapping("/orderHistory/{userid}")
    public List<OrderDto> getOrderHistoryByUserId(@RequestHeader HashMap<String, String> header, @PathVariable int userid){
        UserDto user = userService.getUserById(userid);
        if(user.getPassword().equals(header.get("token"))) return orderService.getOrderHistoryWithUserId(userid);
        else return null;
    }
}
