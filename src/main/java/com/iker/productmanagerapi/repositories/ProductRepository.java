package com.iker.productmanagerapi.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.iker.productmanagerapi.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
    
    // Query para sacar todos los productos
    List<Product> findAll();

    // Query encontrar por Id
    Optional<Product> findById(Long id);
}
