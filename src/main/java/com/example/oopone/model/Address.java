package com.example.oopone.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "address_tbl")
public class Address {

    @Id
    @Column(name = "address_id")
    private int id;

    private String addressline1;
    private String addressline2;
    private String city;
    private String country;

    @Column(nullable = false)
    private int pincode;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;


}