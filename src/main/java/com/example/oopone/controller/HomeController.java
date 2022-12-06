package com.example.oopone.controller;


import com.example.oopone.model.Category;
import com.example.oopone.model.Item;
import com.example.oopone.repository.CategoryRepo;
import com.example.oopone.repository.ItemRepo;
import com.example.oopone.service.CategoryService;
import com.example.oopone.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class HomeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ItemService itemService;


    @GetMapping("/shop")
    public List<Item> get9Items(){
        return itemService.getItemsWithLessPrice();
    }

    @GetMapping("/shop/category/{id}")
    public List<Item> shopByCategory(@PathVariable int id){
        return itemService.getAllItemsByCategoryId(id);
    }

    @GetMapping("/shop/viewproduct/{id}")
    public Item viewProduct(@PathVariable int id){
        return itemService.getItemById(id).get();
    }
}
