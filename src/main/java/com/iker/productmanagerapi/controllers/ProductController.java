package com.iker.productmanagerapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.iker.productmanagerapi.entities.Product;
import com.iker.productmanagerapi.services.ProductService;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    public ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }


    @GetMapping("/getAll")
    public List<Product> getAllProducts() {
        return service.findAllProducts();        
    }
    
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        Optional<Product> getProduct = service.findById(id);
        return getProduct;
    }
    

}
