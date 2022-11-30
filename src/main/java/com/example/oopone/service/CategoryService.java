package com.example.oopone.service;

import com.example.oopone.model.Category;
import com.example.oopone.model.Item;
import com.example.oopone.repository.CategoryRepo;
import com.example.oopone.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    ItemService itemService;

    public List<Category> getCategories() {
        return categoryRepo.findAll();
    }
    public Category saveCategory(Category category) {
        return categoryRepo.save(category);
    }
    public void removeCategory(int id){
        List<Item> itemsToDelete = itemRepo.findAllByCategory_Id(id);
        for(Item var: itemsToDelete){
            itemService.removeItemById(var.getId());
        }
        categoryRepo.deleteById(id);
    }

    public Optional<Category> getCategoryById(int id){
        return categoryRepo.findById(id);
    }

    public Category  updateCategoryById(int id , Category category)
    {
        Category category1 = categoryRepo.findById(id).orElseThrow(RuntimeException::new);
        category1.setCategory_name(category.getCategory_name());
        categoryRepo.save(category1);
        return category1;
    }


}
