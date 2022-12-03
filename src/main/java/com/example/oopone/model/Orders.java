package com.example.oopone.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orders_id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDateTime;

    @PrePersist
    private void onCreate(){
        creationDateTime = new Date();
    }

    @Column(nullable = false )
    private int userid;

    @OneToMany(mappedBy = "orders")
    private List<OrderItems> orderItems;

    public Orders(int userid) {
        this.userid = userid;
    }
}
