package com.example.oopone.controller;

import com.example.oopone.model.Category;
import com.example.oopone.model.Item;
import com.example.oopone.service.CategoryService;
import com.example.oopone.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class ManagerController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ItemService itemService;

    //-----CATEGORIES
    @GetMapping(value = "/manager/categories")
    public List<Category> getCat(@RequestHeader HashMap<String, String> header){
        String managerPass = "Manager";
        if(header.get("token").equals(managerPass)) return categoryService.getCategories();
        else return null;
    }

    //Get Category name by Id
    @GetMapping(value = "/manager/category/{id}")
    public Optional<Category> getCatById(@RequestHeader HashMap<String, String> header,@PathVariable int id){
        String managerPass = "Manager";
        if(header.get("token").equals(managerPass)) return categoryService.getCategoryById(id);
        else return null;
    }

    //Adding new categories.
    @PostMapping(value = "/manager/categories/add")
    public Category addCategory(@RequestHeader HashMap<String, String> header,@RequestBody Category category){
        String managerPass = "Manager";
        if(header.get("token").equals(managerPass)) return categoryService.saveCategory(category);
        else return null;
    }

    //Deleting categories.
    @DeleteMapping("/manager/categories/delete/{id}")
    public void deleteCategory(@RequestHeader HashMap<String, String> header,@PathVariable int id){
        String managerPass = "Manager";
        if(header.get("token").equals(managerPass)) categoryService.removeCategory(id);
    }

    //Updating categories.
    @PutMapping("/manager/categories/update/{id}")
    public Category updateCategory(@RequestHeader HashMap<String, String> header,@PathVariable int id, @RequestBody Category category){
        String managerPass = "Manager";
        if(header.get("token").equals(managerPass)) return categoryService.updateCategoryById(id, category);
        else return null;
    }

    //------ITEMS

    //Getting all items.
    @GetMapping("/manager/items")
    public List<Item> getItems(@RequestHeader HashMap<String, String> header){

        String managerPass = "Manager";
        if(header.get("token").equals(managerPass)) return itemService.getItems();
        else return null;
    }

    //IN PROCESS.
    @GetMapping("/manager/item/maxoffer")
    public Item getItemByMaxOffer(@RequestHeader HashMap<String, String> header){
        String managerPass = "Manager";
        if(header.get("token").equals(managerPass)) return itemService.getItemWithMaxOffer();
        else return null;
    }


    @GetMapping("/manager/items/category/{id}")
    public List<Item> getItemsByCategory(@RequestHeader HashMap<String, String> header,@PathVariable int id){
        String managerPass = "Manager";
        if(header.get("token").equals(managerPass)) return itemService.getAllItemsByCategoryId(id);
        else return null;
    }


    // Adding new items.
    @PostMapping("/manager/items/add/{id}")
    public Item addItemByCatId(@RequestHeader HashMap<String, String> header,@PathVariable int id , @RequestBody Item item) {
        String managerPass = "Manager";
        if(header.get("token").equals(managerPass)) return itemService.saveItem(id,item);
        else return null;
    }

    //Deleting items.
    @DeleteMapping("/manager/items/delete/{id}")
    public void deleteItem(@RequestHeader HashMap<String, String> header,@PathVariable int id){
        String managerPass = "Manager";
        if(header.get("token").equals(managerPass)) itemService.removeItemById(id);
    }

    //Updating Items.
    @PutMapping("/manager/items/update/{id}")
    public Item updateItem(@RequestHeader HashMap<String, String> header,@PathVariable int id, @RequestBody Item item){
        String managerPass = "Manager";
        if(header.get("token").equals(managerPass)) return itemService.updateItemById(id,item);
        else return null;
    }
}
