package com.example.oopone.service;

import com.example.oopone.model.Category;
import com.example.oopone.model.Item;
import com.example.oopone.repository.CategoryRepo;
import com.example.oopone.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public class ItemService {

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    CategoryRepo categoryRepo;

    public List<Item> getItems() {
        return itemRepo.findAll();
    }

    public Item saveItem(int id , Item item) {
        Category category = categoryRepo.findById(id).orElse(null);
        item.setCategory(category);
        return itemRepo.save(item);
    }

    public void removeItemById(int id){
        itemRepo.deleteById(id);
    }

    public Item updateItemById(int id , Item item){
        Item item1 = itemRepo.findById(id).orElse(null);
        item1.setItem_name(item.getItem_name());
        item1.setOffer(item.getOffer());
        item1.setPrice(item.getPrice());
        item1.setDelivery_time(item.getDelivery_time());
        item1.setQty_avlb(item.getQty_avlb());
        item1.setCategory(item.getCategory());
        item1.setDescription(item.getDescription());
        item1.setImg_name(item.getImg_name());
        itemRepo.save(item1);
        return item1;
    }


    public Item getItemWithMaxOffer(){
        return itemRepo.findTopByOrderByOfferDesc();
    }

    public List<Item> getAllItemsByCategoryId(int id){
        return itemRepo.findAllByCategory_Id(id);
    }

    public List<Item> getItemsWithLessPrice(){
        return itemRepo.findTop9ByOrderByPriceAsc();
    }
}
