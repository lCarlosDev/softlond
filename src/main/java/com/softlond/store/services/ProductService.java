package com.softlond.store.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.softlond.store.entities.Product;
import com.softlond.store.repositories.IProductRespository;

@Service
public class ProductService {

    @Autowired
    private IProductRespository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findAllByCategory(Long id) {
        List<Product> productsAnswer = new ArrayList<Product>();
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            if (product.getCategory().getId() == id) {
                productsAnswer.add(product);
            }
        }
        return productsAnswer;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public ResponseEntity<?> deleteProduct(Product product) {
        try {
            productRepository.delete(product);
            return ResponseEntity.ok("El producto fue eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

    public ResponseEntity<Product> updateProduct(Product updateProduct) {
        Product existingProduct = productRepository.findById(updateProduct.getId()).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(updateProduct.getName());
            productRepository.save(existingProduct);
            return ResponseEntity.ok(existingProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
