package com.domain.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.models.entities.Product;
import com.domain.services.ProductServices;

@RestController
@RequestMapping("/api/produk")
public class ProductController {
    
    @Autowired
    private ProductServices productServices;
    
    @PostMapping
    public Product create(@RequestBody Product product){
        return productServices.save(product);
    }
    
    @GetMapping
    public Iterable<Product> findAll(){
        return productServices.findAll();
    }
    
    @GetMapping("/{id}")
    public Product findOne(@PathVariable("id") Long id){
        return productServices.findOne(id);
    }
    
    @PutMapping
    public Product update(@RequestBody Product product){
        return productServices.save(product);
    }

    @DeleteMapping("/{id}")
    public void  removeOne(@PathVariable("id") Long id){
        productServices.removeOne(id);
    }
}
