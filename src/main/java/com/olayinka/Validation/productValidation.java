package com.olayinka.Validation;

import com.olayinka.DTOs.ProductDTO;
import com.olayinka.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

public class productValidation {



    public static ProductDTO validateProduct(ProductDTO product){
        if (product == null || product.getName() == null || product.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }

        String productName = product.getName().trim();
        productName = StringUtils.capitalize(productName.toLowerCase());
        product.setName(productName);

        return product;
    }
}
