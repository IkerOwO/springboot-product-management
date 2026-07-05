package com.iker.productmanagerapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iker.productmanagerapi.entities.Product;
import com.iker.productmanagerapi.repositories.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    public ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }
    
    // Retornar todos los productos
    @Transactional(readOnly = true)
    public List<Product> findAllProducts(){
        return repository.findAll();
    } 

    // Buscar por ID
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id){
        return repository.findById(id);
    }

    // Eliminar por Id
    @Transactional
    public void deleteById(Long id){
        Optional<Product> findProduct = repository.findById(id);
        findProduct.ifPresentOrElse(
            product -> repository.delete(product), 
            () -> System.out.println("PRODUCTO NO ENCONTRADO")
        );
    }

    // Crear producto
    @Transactional
    public void createProduct(Product product){
        // Comprobamos que no existe el producto introducido
        Optional<Product> prOptional = repository.findById(product.getId());
        if (prOptional.isPresent()){
            throw new IllegalStateException("El producto ya existe");
        }
        repository.save(product);   
    }

}
