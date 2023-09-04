package com.softlond.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softlond.store.entities.Category;
import com.softlond.store.entities.Product;
import com.softlond.store.services.ProductService;

@RestController
// Nos da la URL base para acceder a este servicio
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Habilita para que mediante peticiones get se generen respuestas
    @GetMapping("/forCategoryId")
    private ResponseEntity<?> getAllProductsByCategory(@RequestBody Category category) {
        try {
            return ResponseEntity.ok(productService.findAllByCategory(category.getId()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/create")
    private ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @DeleteMapping("delete")
    private ResponseEntity<?> deleteProduct(@RequestBody Product product) {
        return productService.deleteProduct(product);

    }

    @PutMapping("update")
    private ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }
}
