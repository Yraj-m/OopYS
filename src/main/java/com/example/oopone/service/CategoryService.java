package com.example.oopone.service;

import com.example.oopone.model.Category;
import com.example.oopone.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    public List<Category> getCategories() {
        return categoryRepo.findAll();
    }
    public Category saveCategory(Category category) {
        return categoryRepo.save(category);
    }
    public void removeCategory(int id){
        categoryRepo.deleteById(id);
    }

    public Optional<Category> getCategoryById(int id){
        return categoryRepo.findById(id);
    }

    public Category  updateCategoryById(int id , Category category)
    {
        Category category1 = categoryRepo.findById(id).orElseThrow(RuntimeException::new);
        category1.setCategory_name(category.getCategory_name());
        return category1;
    }


}
