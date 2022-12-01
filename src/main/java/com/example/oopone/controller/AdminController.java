package com.example.oopone.controller;

import com.example.oopone.model.Category;
import com.example.oopone.model.Item;
import com.example.oopone.service.CategoryService;
import com.example.oopone.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class AdminController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ItemService itemService;

    // If clicked on admin button, it will go to admin home page.
//    @GetMapping("/admin")
//    public String adminHome(){
//        return "adminHome";
//    }

    //------CATEGORIES

    // Clicking on categories, takes me to all the categories present.
    @GetMapping(value = "/categories")
    public List<Category> getCat(){
        return categoryService.getCategories();
    }

    //Get Category name by Id
    @GetMapping(value = "/category/{id}")
    public Optional<Category> getCatById(@PathVariable int id){
        return categoryService.getCategoryById(id);
    }

    //Adding new categories.
    @PostMapping(value = "/categories/add")
    public Category addCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    //Deleting categories.
    @DeleteMapping("/admin/categories/delete/{id}")
    public void deleteCategory(@PathVariable int id){
        categoryService.removeCategory(id);
    }

    //Updating categories.
    @PutMapping("/admin/categories/update/{id}")
    public Category updateCategory(@PathVariable int id, @RequestBody Category category){
        return categoryService.updateCategoryById(id, category);
    }


    //------ITEMS

    //Getting all items.
    @GetMapping("/admin/items")
    public List<Item> getItems(){
        return itemService.getItems();
    }

    //IN PROCESS.
    @GetMapping("/admin/item/maxoffer")
    public Item getItemByMaxOffer(){
        return itemService.getItemWithMaxOffer();
    }


    @GetMapping("/admin/items/category/{id}")
    public List<Item> getItemsByCategory(@PathVariable int id){
        return itemService.getAllItemsByCategoryId(id);
    }


    // Adding new items.
    @PostMapping("/admin/items/add/{id}")
    public Item addItemByCatId(@PathVariable int id , @RequestBody Item item) {
        return itemService.saveItem(id,item);
    }

    //Deleting items.
    @DeleteMapping("/admin/items/delete/{id}")
    public void deleteItem(@PathVariable int id){
        itemService.removeItemById(id);
    }

    //Updating Items.
    @PutMapping("/admin/items/update/{id}")
    public Item updateItem(@PathVariable int id, @RequestBody Item item){
        return itemService.updateItemById(id,item);
    }
}
