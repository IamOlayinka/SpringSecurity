package com.olayinka.Repository;

import com.olayinka.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.math.BigDecimal;
import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer>{

    List<Product> findProductByName(String name);

    boolean existsByNameIgnoreCase(String productName);

    List<Product> findByBrand(String brand);

    @Query("SELECT p FROM Product p WHERE p.averageRating >= :minRating")
    List<Product> findByMinimumRating(@Param("minRating") BigDecimal minRating);

    @Query("SELECT p FROM Product p WHERE p.quantityInStock > 0")
    List<Product> findInStockProducts();
}
