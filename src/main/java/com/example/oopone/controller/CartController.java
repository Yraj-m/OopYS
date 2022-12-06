package com.example.oopone.controller;



import com.example.oopone.dto.UserDto;
import com.example.oopone.model.CartItems;
import com.example.oopone.model.User;
import com.example.oopone.service.CartItemsService;
import com.example.oopone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class CartController {

    @Autowired
    UserService userService;
    @Autowired
    CartItemsService cartItemsService;

    @PostMapping("/addToCart/{userid}/{itemid}")
    public CartItems addToCart(@RequestHeader HashMap<String, String> header, @PathVariable int userid, @PathVariable int itemid) {
        UserDto user = userService.getUserById(userid);
        if(user.getPassword().equals(header.get("token"))) return cartItemsService.saveToCart(userid, itemid);
        else return null;
    }

    @GetMapping(value = "/cart/user/{userid}")
    public List<CartItems> getCartUser(@RequestHeader HashMap<String, String> header,@PathVariable int userid) {
        UserDto user = userService.getUserById(userid);
        if(user.getPassword().equals(header.get("token"))) return cartItemsService.getAllCartItems(userid);
        else return null;
    }

    @DeleteMapping("/removeItem/{userid}/{itemid}")
    public void removeFromCart(@RequestHeader HashMap<String, String> header,@PathVariable int userid, @PathVariable int itemid) {
        UserDto user = userService.getUserById(userid);
        if(user.getPassword().equals(header.get("token"))) cartItemsService.removeItemFromCart(userid, itemid);
    }

   @GetMapping("/cartvalue/{userid}")
    public double getCartValue(@RequestHeader HashMap<String, String> header,@PathVariable int userid){
       UserDto user = userService.getUserById(userid);
       if(user.getPassword().equals(header.get("token"))) return cartItemsService.calculateCartValue(userid);
       else return 0.0;
    }
}
