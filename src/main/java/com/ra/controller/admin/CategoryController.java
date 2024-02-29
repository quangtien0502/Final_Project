package com.ra.controller.admin;

import com.ra.model.entity.Category;
import com.ra.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/admin/categories")
@Controller
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String getAllCategory(Model model){
        List<Category> categoryList=categoryService.getAll();
        model.addAttribute("categoryList",categoryList);
        return "admin/categories";
    }

    @PostMapping("")
    public String createCategory(@ModelAttribute Category category){
        Category categoryFinal=categoryService.save(category);
        return "redirect:/v1/admin/categories";
    }

    @GetMapping("/delete/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId){
        Category category=categoryService.findById(categoryId);
        category.setIsDeleted(true);
        categoryService.save(category);
        return "redirect:/v1/admin/categories";
    }

    @GetMapping("/addCategory")
    public String addCategory(){
        return "admin/add-new-categories";
    }

    @GetMapping("/edit/{categoryId}")
    public String editCategory(@PathVariable Long categoryId,Model model){
        Category category=categoryService.findById(categoryId);
        model.addAttribute("category",category);
        return "admin/edit-categories";
    }

    @PostMapping("/edit")
    public String updateCategory(@ModelAttribute Category category){
        Category categoryFinal=categoryService.findById(category.getId());
        categoryFinal.setCategoryName(category.getCategoryName());
        categoryFinal.setDescription(category.getDescription());
        categoryFinal=categoryService.save(categoryFinal);
        return "redirect:/v1/admin/categories";
    }


}
