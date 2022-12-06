package com.example.oopone.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;

import java.util.List;

@Data
@Entity
@Table(name = "user_tbl")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    private int phonenumber;

    @Column(nullable = false)
    @NotEmpty
    @Email(message = "{Invalid Email!!}")
    private String emailid;

    private double wallet_amt;

    private String addressline1;
    private String addressline2;
    private String city;
    private String country;

    @Column(nullable = false)
    private int pincode;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
    private List<Role> roles;

    public User(String username, String password, int phonenumber, String emailid, double wallet_amt, String addressline1, String addressline2, String city, String country, int pincode) {
        this.username = username;
        this.password = password;
        this.phonenumber = phonenumber;
        this.emailid = emailid;
        this.wallet_amt = wallet_amt;
        this.addressline1 = addressline1;
        this.addressline2 = addressline2;
        this.city = city;
        this.country = country;
        this.pincode = pincode;
    }

    public User(String username, String password, int phonenumber, String emailid, double wallet_amt, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.phonenumber = phonenumber;
        this.emailid = emailid;
        this.wallet_amt = wallet_amt;
        this.roles = roles;
    }

    public User() {
    }
}