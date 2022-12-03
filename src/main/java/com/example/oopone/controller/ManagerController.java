package com.example.oopone.controller;

import com.example.oopone.model.Category;
import com.example.oopone.model.Item;
import com.example.oopone.service.CategoryService;
import com.example.oopone.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ManagerController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ItemService itemService;

    //-----CATEGORIES
    @GetMapping(value = "/manager/categories")
    public List<Category> getCat(){
        return categoryService.getCategories();
    }

    //Get Category name by Id
    @GetMapping(value = "/manager/category/{id}")
    public Optional<Category> getCatById(@PathVariable int id){
        return categoryService.getCategoryById(id);
    }

    //Adding new categories.
    @PostMapping(value = "/manager/categories/add")
    public Category addCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    //Deleting categories.
    @DeleteMapping("/manager/categories/delete/{id}")
    public void deleteCategory(@PathVariable int id){
        categoryService.removeCategory(id);
    }

    //Updating categories.
    @PutMapping("/manager/categories/update/{id}")
    public Category updateCategory(@PathVariable int id, @RequestBody Category category){
        return categoryService.updateCategoryById(id, category);
    }

    //------ITEMS

    //Getting all items.
    @GetMapping("/manager/items")
    public List<Item> getItems(){
        return itemService.getItems();
    }

    //IN PROCESS.
    @GetMapping("/manager/item/maxoffer")
    public Item getItemByMaxOffer(){
        return itemService.getItemWithMaxOffer();
    }


    @GetMapping("/manager/items/category/{id}")
    public List<Item> getItemsByCategory(@PathVariable int id){
        return itemService.getAllItemsByCategoryId(id);
    }


    // Adding new items.
    @PostMapping("/manager/items/add/{id}")
    public Item addItemByCatId(@PathVariable int id , @RequestBody Item item) {
        return itemService.saveItem(id,item);
    }

    //Deleting items.
    @DeleteMapping("/manager/items/delete/{id}")
    public void deleteItem(@PathVariable int id){
        itemService.removeItemById(id);
    }

    //Updating Items.
    @PutMapping("/manager/items/update/{id}")
    public Item updateItem(@PathVariable int id, @RequestBody Item item){
        return itemService.updateItemById(id,item);
    }
}
