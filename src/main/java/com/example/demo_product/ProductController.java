package com.example.demo_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public Product createProduct(Product product){
        return productService.creatProduct(product);
    }

    @GetMapping("/allproducts")
    public List<Product> getAllProducts(Product product){
        return productService.getAllProducts(product);
    }
}
