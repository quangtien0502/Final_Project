package com.ra.repository;

import com.ra.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    List<Category> getCategoriesByIsDeletedIsFalse();

    List<Category> getAllByStatus(Boolean status);

}
