package com.example.oopone.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "cartiitem_tbl")
public class CartItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Item item;

    private int quantity_in_cart;

    private int userid;

    public CartItems(Item item, int quantity_in_cart, int userid) {
        this.item = item;
        this.quantity_in_cart = quantity_in_cart;
        this.userid = userid;
    }
}
