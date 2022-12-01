package com.example.oopone.repository;


import com.example.oopone.model.Cart;
import com.example.oopone.model.Item;
import com.example.oopone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepo extends JpaRepository<Cart,Integer> {

    Boolean existsByItemAndUser(Item item , User user);

    Cart findByItemAndUser(Item item , User user);
}
