package com.example.oopone.service;


import com.example.oopone.model.Cart;
import com.example.oopone.model.Item;
import com.example.oopone.model.User;
import com.example.oopone.repository.CartRepo;
import com.example.oopone.repository.ItemRepo;
import com.example.oopone.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    CartRepo cartRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ItemRepo itemRepo;

    public Cart saveToCart(int userid , int itemid) {
        User user = userRepo.findById(userid).get();
        Item item = itemRepo.findById(itemid).get();
        Boolean bool = cartRepo.existsByItemAndUser(item, user);
        Cart cart = new Cart();
        if (bool)
        {
            cart = cartRepo.findByItemAndUser(item,user);
            cart.setQuantity_incart(cart.getQuantity_incart() + 1);
        }
        else
        {
            cart.setItem(item);
            cart.setUser(user);
            cart.setQuantity_incart(1);
        }

        return cartRepo.save(cart);

    }

    public User cartUser(int id){
        return cartRepo.findById(id).get().getUser();
    }




}
