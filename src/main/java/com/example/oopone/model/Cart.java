package com.example.oopone.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Table(name = "cart_tbl")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id")
    private int id;


    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    private Item item;

    int quantity_incart ;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userid",referencedColumnName = "id")
    private User user;

    public Cart(Item item, int quantity_incart, User user) {
        this.item = item;
        this.quantity_incart = quantity_incart;
        this.user = user;
    }
}
