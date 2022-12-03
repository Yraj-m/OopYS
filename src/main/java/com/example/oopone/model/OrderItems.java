package com.example.oopone.model;


import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orderitems_tbl")
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private @NotNull int quantity;

    @ManyToOne
    private Orders orders;

    @ManyToOne
    private Item item;

    public OrderItems(int quantity, Orders orders, Item item) {
        this.quantity = quantity;
        this.orders = orders;
        this.item = item;
    }


}
