package com.softlond.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softlond.store.entities.Category;
import com.softlond.store.services.ProductService;

@RestController
// Nos da la URL base para acceder a este servicio
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Habilita para que mediante peticiones get se generen respuestas
    @GetMapping("/categoryId")
    private ResponseEntity<?> getAllProductsByCategory(@RequestBody Category category) {
        try {
            return ResponseEntity.ok(productService.findAllByCategory(category.getId()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
