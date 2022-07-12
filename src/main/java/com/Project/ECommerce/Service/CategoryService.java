package com.Project.ECommerce.Service;

import com.Project.ECommerce.Model.Category;
import com.Project.ECommerce.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository CR;

    public List<Category> getAllCategory(){
        return CR.findAll();
    }
    public void removeCategoryById(int id){CR.deleteById(id);}
    public Optional<Category> getCatById(int id){return CR.findById(id);}
    public void addCategory(Category category){
        CR.save(category);
    }
}
