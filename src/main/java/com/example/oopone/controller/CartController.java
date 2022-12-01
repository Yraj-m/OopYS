package com.example.oopone.controller;


import com.example.oopone.model.Cart;
import com.example.oopone.model.Category;
import com.example.oopone.model.Item;
import com.example.oopone.model.User;
import com.example.oopone.service.CartService;
import com.example.oopone.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController

public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/addToCart/{userid}/{itemid}")
    public Cart addToCart(@PathVariable int userid, @PathVariable int itemid){
        return cartService.saveToCart(userid,itemid);
    }

    @GetMapping(value = "/cart/user/{id}")
    public User  getCartUser(@PathVariable int id){
        return cartService.cartUser(id);
    }
}
