package com.example.oopone.service;

import com.example.oopone.model.CartItems;
import com.example.oopone.model.OrderItems;
import com.example.oopone.model.Orders;
import com.example.oopone.repository.CartItemsRepo;
import com.example.oopone.repository.OrderItemsRepo;
import com.example.oopone.repository.OrdersRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OrderService {


    @Autowired
    CartItemsRepo cartItemsRepo;

    @Autowired
    OrderItemsRepo orderItemsRepo;

    @Autowired
    OrdersRepo ordersRepo;

    public void addOrderedProducts(int user_id) {
        List<CartItems> cartItemsList = cartItemsRepo.findAllByUserid(user_id);
        Orders orders = new Orders(user_id);
        for(CartItems var: cartItemsList){
            OrderItems orderItems = new OrderItems(
                    var.getQuantity_in_cart(),orders,var.getItem()

            );
            orderItemsRepo.save(orderItems);
        }

        ordersRepo.save(orders);

    }
}
