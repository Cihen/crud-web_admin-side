package com.example.project.controller.admin;

import com.example.project.model.Category;
import com.example.project.model.Product;
import com.example.project.repository.ProductRepository;
import com.example.project.service.CategoryService;
import com.example.project.service.ProductService;
import com.example.project.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class ProductController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private StorageService storageService;

    @RequestMapping("/product")
    public String index(Model model) {
        List<Product> listProduct = this.productService.getAll();
        model.addAttribute("listProduct", listProduct);
        return "admin/product/index";
    }

    @RequestMapping("/add-product")
    public String add(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        List<Category> listCate = this.categoryService.getAll();
        model.addAttribute("listCate", listCate);
        return "admin/product/add";
    }

    @PostMapping("/add-product")
    public String save(@ModelAttribute("product") Product product, @RequestParam("fileImage")MultipartFile file) {
        this.storageService.store(file);
        String fileName = file.getOriginalFilename();
        product.setImage(fileName);
        if(this.productService.create(product)) {
            return "redirect:/admin/product";
        }
        return "admin/product/add";
    }
}
