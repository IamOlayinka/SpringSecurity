package com.olayinka.Repository;

import com.olayinka.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer>{

    List<Product> findProductByName(String name);

    boolean existsByNameIgnoreCase(String productName);
}
