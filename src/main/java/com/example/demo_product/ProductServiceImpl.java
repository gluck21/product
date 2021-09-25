package com.example.demo_product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@CacheConfig(cacheNames = "product")
@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;


    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Caching(evict = {@CacheEvict(value = "allproductcache", allEntries = true),
            @CacheEvict(value = "productcache", key = "#product.id")
    })
    @Override
    public Product creatProduct(Product product) {
        return productRepository.save(product);
    }


    @Cacheable(value = "allproductcache")
    @Override
    public List<Product> getAllProducts(Product product) {
        return productRepository.findAll();
    }
}
