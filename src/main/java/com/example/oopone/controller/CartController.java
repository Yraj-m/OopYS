package com.example.oopone.controller;



import com.example.oopone.model.CartItems;
import com.example.oopone.model.User;
import com.example.oopone.service.CartItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class CartController {

    @Autowired
    CartItemsService cartItemsService;

    @PostMapping("/addToCart/{userid}/{itemid}")
    public CartItems addToCart(@PathVariable int userid, @PathVariable int itemid) {
        return cartItemsService.saveToCart(userid, itemid);
    }

    @GetMapping(value = "/cart/user/{id}")
    public List<CartItems> getCartUser(@PathVariable int id) {
        return cartItemsService.getAllCartItems(id);
    }

    @DeleteMapping("/removeItem/{userid}/{itemid}")
    public void removeFromCart(@PathVariable int userid, @PathVariable int itemid) {
        cartItemsService.removeItemFromCart(userid, itemid);
    }

   @GetMapping("/cartvalue/{userid}")
    public double getCartValue(@PathVariable int userid){
        return cartItemsService.calculateCartValue(userid);
}
}
