package com.example.oopone.controller;



import com.example.oopone.model.CartItems;
import com.example.oopone.model.User;
import com.example.oopone.service.CartItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController

public class CartController {

    @Autowired
    CartItemsService cartItemsService;

    @PostMapping("/addToCart/{userid}/{itemid}")
    public CartItems addToCart(@PathVariable int userid, @PathVariable int itemid){
        return
        cartItemsService.saveToCart(userid,itemid);
    }

    @GetMapping(value = "/cart/user/{id}")
    public List<CartItems> getCartUser(@PathVariable int id){
        return cartItemsService.getAllCartItems(id);
   }
}
