package com.olayinka.Controller;

import com.olayinka.DTOs.ProductDTO;
import com.olayinka.Model.Product;
import com.olayinka.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllproducts();
        return ResponseEntity.ok(products);

    }


    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id){
        Product product = productService.getProductById(id);
        System.out.println("From controller" + id);
        return ResponseEntity.ok(product);

    }

    @PostMapping("/product")
    public void addProduct(@RequestBody ProductDTO product){
        productService.addProduct(product);
    }


    @PostMapping("/update-product")
    public void updateProduct(@RequestBody ProductDTO product){
        productService.updateProduct(product);
    }

    @GetMapping("/delete-product")
    public void deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
    }
}
