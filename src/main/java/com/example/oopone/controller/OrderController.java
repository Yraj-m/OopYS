package com.example.oopone.controller;

import com.example.oopone.service.CartItemsService;
import com.example.oopone.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void addOrderedProductsInCart(@PathVariable int userid){
        orderService.addOrderedProducts(userid);
    }
}
