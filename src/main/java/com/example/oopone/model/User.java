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

    @Column(nullable = false,unique = true)
    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    private int phonenumber;

    @Column(nullable = false,unique = true)
    @NotEmpty
    @Email(message = "{Invalid Email!!}")
    private String emailid;

    private double wallet_amt;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
    private List<Role> roles;

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