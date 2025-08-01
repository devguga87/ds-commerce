package com.devsuperior.dscommerce.repositories;

import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT obj FROM Product obj " +
            "WHERE UPPER(obj.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<Product> searchByName(String name, Pageable pageable);

    //    default Product getById(Long id) {
    //        return findById(id).orElseThrow(
    //                () -> new ResourceNotFoundException("Recurso não encontrado"));
    //    }
}
