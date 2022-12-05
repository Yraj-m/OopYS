package com.example.oopone.dto;



import com.example.oopone.model.CartItems;
import com.example.oopone.model.OrderItems;
import com.example.oopone.model.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor@NoArgsConstructor@ToString
@Data
public class OrderDto {

    private int id;
    private int userid;
    private Date creationDateTime;
    private List<OrderItemsDto> orderItemsDtos;

    public OrderDto(Orders orders) {

        this.id = orders.getOrders_id();
        this.userid = orders.getUserid();
        this.creationDateTime = orders.getCreationDateTime();
        orderItemsDtos = new ArrayList<>();
        for (OrderItems var : orders.getOrderItems()) {
            orderItemsDtos.add(new OrderItemsDto(var));
        }
    }
}
