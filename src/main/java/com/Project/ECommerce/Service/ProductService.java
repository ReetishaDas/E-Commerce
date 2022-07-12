package com.Project.ECommerce.Service;

import com.Project.ECommerce.Model.Product;
import com.Project.ECommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository PR;
    public List<Product> getAllProduct(){
        return PR.findAll();
    }
    public void addProduct(Product product){
        PR.save(product);
    }
    public void removeProduct(long id){
        PR.deleteById(id);
    }
    public Optional<Product> getProductById(long id){
        return PR.findById(id);
    }
    public List<Product> getAllProductsByCategoryId(int id){
        return PR.findAllByCategory_Id(id);
    }
}
