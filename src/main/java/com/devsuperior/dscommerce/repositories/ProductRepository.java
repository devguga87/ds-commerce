package com.devsuperior.dscommerce.repositories;

import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    default Product getById(Long id) {
        return findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
    }
}
