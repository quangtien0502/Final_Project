package com.ra.service;

import com.ra.model.entity.Category;
import com.ra.model.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();

    Product findById(Long id);

    void deleteById(Long id);

    Product save(Product product);
}
