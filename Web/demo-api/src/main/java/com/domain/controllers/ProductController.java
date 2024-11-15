package com.domain.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.dto.ResponseData;
import com.domain.models.entities.Product;
import com.domain.services.ProductServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produk")
public class ProductController {
    
    @Autowired
    private ProductServices productServices;
    
    @PostMapping
    public ResponseEntity<ResponseData<Product>> create(@Valid @RequestBody Product product, Errors errors){

        ResponseData<Product> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());              
            }
            responseData.setStatus(false);
            responseData.setPayloadT(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayloadT(productServices.save(product));
        return ResponseEntity.ok(responseData);
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
    public ResponseEntity<ResponseData<Product>> update(@Valid @RequestBody Product product, Errors errors){
        ResponseData<Product> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());              
            }
            responseData.setStatus(false);
            responseData.setPayloadT(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayloadT(productServices.save(product));
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/{id}")
    public void  removeOne(@PathVariable("id") Long id){
        productServices.removeOne(id);
    }
}
