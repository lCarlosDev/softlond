package com.softlond.store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.softlond.store.entities.Category;
import com.softlond.store.repositories.ICategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public ResponseEntity<?> deleteCategory(Category category) {
        try {
            categoryRepository.delete(category);
            return ResponseEntity.ok("La categoría se eliminó correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

    public ResponseEntity<Category> updateCategory(Category updatedCategory) {
        Category existingCategory = categoryRepository.findById(updatedCategory.getId()).orElse(null);

        if (existingCategory != null) {
            existingCategory.setName(updatedCategory.getName());

            categoryRepository.save(existingCategory);
            return ResponseEntity.ok(existingCategory);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
