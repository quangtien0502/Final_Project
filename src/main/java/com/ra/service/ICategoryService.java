package com.ra.service;

import com.ra.model.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAll();

    Category findById(Long id);

    void deleteById(Long id);

    Category save(Category category);
}
