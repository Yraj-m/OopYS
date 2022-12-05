package com.example.oopone.controller;

import com.example.oopone.dto.OrderDto;
import com.example.oopone.model.Orders;
import com.example.oopone.service.CartItemsService;
import com.example.oopone.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    CartItemsService cartItemsService;

    @Autowired
    OrderService orderService;


    @DeleteMapping("/order/{userid}")
    public void order(@PathVariable int userid){
        cartItemsService.deleteAllItemsFromCart(userid);
    }

    @PostMapping("/addOrder/{userid}")
    public String addOrderedProductsInCart(@PathVariable int userid){
        return orderService.addOrderedProducts(userid);
    }

    @GetMapping("/orderHistory/{userid}")
    public List<OrderDto> getOrderHistoryByUserId(@PathVariable int userid){
        return orderService.getOrderHistoryWithUserId(userid);
    }
}
