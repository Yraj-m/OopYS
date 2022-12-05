package com.example.oopone.dto;



import com.example.oopone.model.Item;
import com.example.oopone.model.OrderItems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor@NoArgsConstructor@ToString
public class OrderItemsDto {

    private Integer id;
    private int quantity;
    private int item_id;
    private String item_name;
    private double price;

    public OrderItemsDto(OrderItems orderItems) {
        this.id = orderItems.getId();
        this.quantity = orderItems.getQuantity();
        Item item = orderItems.getItem();
        this.item_id = item.getId();
        this.item_name = item.getItem_name();
        this.price = item.getPrice();
    }
}
