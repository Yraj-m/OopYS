package com.example.oopone.service;

import com.example.oopone.dto.OrderDto;
import com.example.oopone.dto.OrderItemsDto;
import com.example.oopone.dto.UserDto;
import com.example.oopone.model.CartItems;
import com.example.oopone.model.OrderItems;
import com.example.oopone.model.Orders;
import com.example.oopone.model.User;
import com.example.oopone.repository.CartItemsRepo;
import com.example.oopone.repository.OrderItemsRepo;
import com.example.oopone.repository.OrdersRepo;
import com.example.oopone.repository.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.oopone.exception.SumExceedsException;
import com.example.oopone.exception.CartEmptyException;
import com.example.oopone.exception.QuantityExceedsException;

import java.util.ArrayList;
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

    @Autowired
    UserRepo userRepo;

    @Autowired
    CartItemsService cartItemsService;

    public String addOrderedProducts(int user_id) {
        List<CartItems> cartItemsList = cartItemsRepo.findAllByUserid(user_id);
        if(cartItemsList.isEmpty()){
            throw new CartEmptyException("The Cart is Empty");
        }
        else {
            User user = userRepo.findById(user_id).get();
            double wallet_amount = user.getWallet_amt();
            double sum = cartItemsService.calculateCartValue(user_id);
            if (sum > wallet_amount) {
                throw new SumExceedsException("The Sum Exceeds the Amount you have in your wallet");
            } else {

                for(CartItems var : cartItemsList){

                    if(var.getQuantity_in_cart() > var.getItem().getQty_avlb()) {
                        throw new QuantityExceedsException("Quantity Ordered for item: " + var.getItem().getId() +" more than Quantity Available");
                    }
                }
                for(CartItems var : cartItemsList){
                    var.getItem().setQty_avlb(var.getItem().getQty_avlb() - var.getQuantity_in_cart());

                }



                Orders orders = new Orders(user_id);
                for (CartItems var : cartItemsList) {
                    OrderItems orderItems = new OrderItems(
                            var.getQuantity_in_cart(), orders, var.getItem()

                    );
                    cartItemsRepo.deleteById(var.getId());
                    orderItemsRepo.save(orderItems);
                    user.setWallet_amt(user.getWallet_amt() - sum);
                }

                ordersRepo.save(orders);
                return "Added Order Successfully";
            }
        }

    }

    public List<OrderDto> getOrderHistoryWithUserId(int user_id) {

        List<OrderDto> orderDtoList = new ArrayList<>();
        for (Orders var : ordersRepo.findAllByUserid(user_id)) {
            orderDtoList.add(new OrderDto(var));

        }
        return orderDtoList;
    }

}
