package com.ra.repository;

import com.ra.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAllByStatus(Boolean status);

    List<Product> findAllByProductNameContainingOrDescriptionContaining(String categoryName,String description);
}
