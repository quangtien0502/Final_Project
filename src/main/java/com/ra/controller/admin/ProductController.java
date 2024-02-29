package com.ra.controller.admin;

import com.ra.model.DTO.request.ProductRequest;
import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.service.ICategoryService;
import com.ra.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/v1/admin/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String getAllProduct(Model model){
        List<Product> productList=productService.getAll();
        model.addAttribute("productList",productList);
        return "admin/products";
    }

    @PostMapping("")
    public String createProduct(@ModelAttribute ProductRequest productRequest){
        Category category=categoryService.findById(productRequest.getCategoryId());
        Product product= Product.builder()
                .productName(productRequest.getProductName())
                .description(productRequest.getDescription())
                .unitPrice(productRequest.getUnitPrice())
                .category(category)
                .stockQuantity(productRequest.getStockQuantity())
                .createdAt(new Date())
                .sku(UUID.randomUUID().toString())
                .image(productRequest.getImage())
                .build();
        product=productService.save(product);
        return "redirect:/v1/admin/product";
    }

    @GetMapping("/edit/{productId}")
    public String editProduct(@PathVariable Long productId,Model model){
        Product product=productService.findById(productId);
        List<Category> categoryList=categoryService.getAll();
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("product",product);
        return "admin/edit-product";
    }

    @PostMapping("/edit/product")
    public String updateProduct(@ModelAttribute Product product){
        Product productConvert=productService.findById(product.getId());
        productConvert.setCategory(product.getCategory());
        productConvert.setProductName(product.getProductName());
        productConvert.setDescription(product.getDescription());
        productConvert.setUnitPrice(product.getUnitPrice());
        productConvert.setStockQuantity(product.getStockQuantity());
        productConvert.setUpdatedAt(new Date());
        Product productFinal=productService.save(productConvert);
        return "redirect:/v1/admin/product";
    }

    @GetMapping("/addProduct")
    public String addProduct(Model model){
        List<Category> categoryList=categoryService.getAll();
        model.addAttribute("categoryList",categoryList);
        return "admin/add-new-product";
    }
}
