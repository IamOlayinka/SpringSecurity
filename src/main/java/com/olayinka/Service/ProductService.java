package com.olayinka.Service;


import com.olayinka.DTOs.ProductDTO;
import com.olayinka.Model.Product;
import com.olayinka.Repository.ProductRepo;
import com.olayinka.Validation.productValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productrepo;

    public List<Product>getAllproducts() {
        List<Product> products =  productrepo.findAll();
        return products;
    }

    public Product getProductById(int id) {
        System.out.println("From service" + id);

        return productrepo.getReferenceById(id);
    }

    public void addProduct(ProductDTO product) {
        if (product == null || product.getName() == null || product.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }

        String productName = product.getName().trim();
        productName = StringUtils.capitalize(productName.toLowerCase());

        if (productrepo.existsByNameIgnoreCase(productName)) {
            throw new IllegalArgumentException("Product already exists");
        }

        Product entity = new Product();
        // set properties from DTO
        entity.setName(productName);
        entity.setBrand(product.getBrand());
        entity.setDescription(product.getDescription());
        entity.setQuantityInStock(product.getQuantityInStock());
        entity.setImageUrl(product.getImageUrl());
        entity.setPrice(product.getPrice());
        entity.setRating(product.getRating());
        productrepo.save(entity);
    }

    public void updateProduct(ProductDTO productDTO) {

        ProductDTO product = productValidation.validateProduct(productDTO);

        if (productrepo.existsByNameIgnoreCase(product.getName())) {
            throw new IllegalArgumentException("Product already exists");
        }

        Product entity = new Product();
        // set properties from DTO
        entity.setName(product.getName());
        entity.setBrand(product.getBrand());
        entity.setDescription(product.getDescription());
        entity.setQuantityInStock(product.getQuantityInStock());
        entity.setImageUrl(product.getImageUrl());
        entity.setPrice(product.getPrice());
        entity.setRating(product.getRating());
        productrepo.save(entity);


    }

    public void deleteProduct(int id) {
        productrepo.deleteById(id);
    }
}
