package com.example.oopone.repository;

import com.example.oopone.model.CartItems;
import com.example.oopone.model.Item;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CartItemsRepo extends JpaRepository<CartItems,Integer> {

    public Boolean existsByUseridAndItem(int userid, Item  item);
    public CartItems findByUseridAndItem(int userid , Item  item);

    @Transactional
    public void deleteAllByUserid(int userid);

    public List<CartItems> findAllByUserid(int userid);

}
