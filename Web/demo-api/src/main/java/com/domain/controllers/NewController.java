package com.domain.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/new")
public class NewController {
    
    @GetMapping
    public String welcome(){
        return"Welcome to Rest API";
    }
}