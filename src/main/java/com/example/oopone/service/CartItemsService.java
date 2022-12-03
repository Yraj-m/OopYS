package com.example.oopone.service;


import com.example.oopone.model.CartItems;
import com.example.oopone.model.Item;
import com.example.oopone.repository.CartItemsRepo;
import com.example.oopone.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemsService {

    @Autowired
    CartItemsRepo cartItemsRepo;

    @Autowired
    ItemRepo itemRepo;


    public CartItems saveToCart(int userid , int itemid){

        Item item = itemRepo.findById(itemid).get();
        CartItems cartItems;

        if(cartItemsRepo.existsByUseridAndItem(userid,item))
        {
            cartItems = cartItemsRepo.findByUseridAndItem(userid,item);
            cartItems.setQuantity_in_cart(cartItems.getQuantity_in_cart()+1);
        }
        else
        {
            cartItems = new CartItems(item,1,userid);
        }

        return cartItemsRepo.save(cartItems);
    }

    public List<CartItems> getAllCartItems(int userid){
        return cartItemsRepo.findAllByUserid(userid);
    }

}
