package com.example.project.service;

import com.example.project.model.Category;
import com.example.project.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Boolean create(Product product);
    Product findById(int id);
    Boolean update(Product product);
    Boolean delete(int id);
}
