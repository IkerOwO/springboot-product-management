package com.iker.productmanagerapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.iker.productmanagerapi.entities.Product;
import com.iker.productmanagerapi.services.ProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

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
    
    @PostMapping("/create")
    public void createProduct(@RequestBody Product product) {
        service.createProduct(product);
    }
    
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateStock(@PathVariable Product product, @RequestBody int newStock) {
        service.updateStock(product, newStock);
    }
}
