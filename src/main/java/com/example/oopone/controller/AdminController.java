package com.example.oopone.controller;

import com.example.oopone.model.Category;
import com.example.oopone.model.Item;
import com.example.oopone.service.CategoryService;
import com.example.oopone.service.ItemService;
import com.example.oopone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class AdminController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ItemService itemService;

    @Autowired
    UserService userService;

    public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages";

    // If clicked on admin button, it will go to admin home page.
//    @GetMapping("/admin")
//    public String adminHome(){
//        return "adminHome";
//    }

    //------CATEGORIES

    // Clicking on categories, takes me to all the categories present.
    @GetMapping(value = "/admin/categories")
    public List<Category> getCat(@RequestHeader HashMap<String, String> header){
        String adminPass = "1234";
        if(header.get("token").equals(adminPass)){return categoryService.getCategories();}
        else return null;
    }

    //Get Category name by Id
    @GetMapping(value = "/admin/category/{id}")
    public Optional<Category> getCatById(@RequestHeader HashMap<String, String> header,@PathVariable int id){
        String adminPass = "1234";
        if(header.get("token").equals(adminPass)){return  categoryService.getCategoryById(id);}
        else return null;
    }

    //Adding new categories.
    @PostMapping(value = "/admin/categories/add")
    public Category addCategory(@RequestHeader HashMap<String, String> header, @RequestBody Category category){
        String adminPass = "1234";
        if(header.get("token").equals(adminPass)){return categoryService.saveCategory(category);}
        else return null;
    }

    //Deleting categories.
    @DeleteMapping("/admin/categories/delete/{id}")
    public void deleteCategory(@RequestHeader HashMap<String, String> header, @PathVariable int id){
        String adminPass = "1234";
        if(header.get("token").equals(adminPass)){categoryService.removeCategory(id);}
    }

    //Updating categories.
    @PutMapping("/admin/categories/update/{id}")
    public Category updateCategory(@RequestHeader HashMap<String, String> header, @PathVariable int id, @RequestBody Category category){
        String adminPass = "1234";
        if(header.get("token").equals(adminPass)){return categoryService.updateCategoryById(id, category);}
        else return null;
    }


    //------ITEMS

    //Getting all items.
    @GetMapping("/admin/items")
    public List<Item> getItems(@RequestHeader HashMap<String, String> header){
        String adminPass = "1234";
        if(header.get("token").equals(adminPass)){return itemService.getItems();}
        else return null;
    }

    //IN PROCESS.
    @GetMapping("/admin/item/maxoffer")
    public Item getItemByMaxOffer(@RequestHeader HashMap<String, String> header){
        String adminPass = "1234";
        if(header.get("token").equals(adminPass)){return itemService.getItemWithMaxOffer();}
        else return null;
    }


    @GetMapping("/admin/items/category/{id}")
    public List<Item> getItemsByCategory(@RequestHeader HashMap<String, String> header,@PathVariable int id){
        String adminPass = "1234";
        if(header.get("token").equals(adminPass)){return itemService.getAllItemsByCategoryId(id);}
        else return null;
    }


    // Adding new items.
    @PostMapping("/admin/items/add/{id}")
    public Item addItemByCatId(@RequestHeader HashMap<String, String> header,@PathVariable int id , @RequestBody Item item) {
        String adminPass = "1234";
        if(header.get("token").equals(adminPass)){return itemService.saveItem(id,item);}
        else return null;
    }

    //Deleting items.
    @DeleteMapping("/admin/items/delete/{id}")
    public void deleteItem(@RequestHeader HashMap<String, String> header,@PathVariable int id){
        String adminPass = "1234";
        if(header.get("token").equals(adminPass)){itemService.removeItemById(id);}
    }

    //Updating Items.
    @PutMapping("/admin/items/update/{id}")
    public Item updateItem(@RequestHeader HashMap<String, String> header,@PathVariable int id, @RequestBody Item item){
        String adminPass = "1234";
        if(header.get("token").equals(adminPass)){return itemService.updateItemById(id,item);}
        else return null;
    }

    @DeleteMapping("/admin/user/delete/{id}")
    public void deleteUser(@RequestHeader HashMap<String, String> header,@PathVariable int id){
        String adminPass = "1234";
        if(header.get("token").equals(adminPass)){userService.removeUser(id);}
    }
}
