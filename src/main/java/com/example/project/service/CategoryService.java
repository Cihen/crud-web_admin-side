package com.example.project.service;

import com.example.project.model.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Boolean create(Category category);
    Category findById(int id);
    Boolean update(Category category);
    Boolean delete(int id);
    List<Category> searchCategory(String keyword);

    Page<Category> getAll(Integer pageNo);
    Page<Category> searchCategory(String keyword, Integer pageNo);
}
