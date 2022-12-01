package com.example.oopone.repository;

import com.example.oopone.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ItemRepo extends JpaRepository<Item,Integer> {
    List<Item> findAllByCategory_Id(int id);

    Item findTopByOrderByOfferDesc();

    List<Item> findTop9ByOrderByPriceAsc();



}