package com.softlond.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softlond.store.entities.Category;
import com.softlond.store.services.CategoryService;

@RestController
// Nos da la URL base para acceder a este servicio
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Habilita para que mediante peticiones get se generen respuestas
    @GetMapping("/list")
    private ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @PostMapping("/create")
    private ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    @DeleteMapping("/delete")
    private ResponseEntity<?> deleteCategory(@RequestBody Category category) {
        return categoryService.deleteCategory(category);
    }

    @PutMapping("/update")
    private ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }

}
