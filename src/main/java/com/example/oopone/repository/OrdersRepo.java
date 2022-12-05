package com.example.oopone.repository;

import com.example.oopone.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrdersRepo extends JpaRepository<Orders,Integer> {
    public List<Orders> findAllByUserid(int userid);

}
