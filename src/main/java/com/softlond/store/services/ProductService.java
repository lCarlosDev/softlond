package com.softlond.store.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softlond.store.entities.Product;
import com.softlond.store.repositories.IProductRespository;

@Service
public class ProductService {

    @Autowired
    private IProductRespository productRespository;

    public List<Product> findAll() {
        return productRespository.findAll();
    }

    public List<Product> findAllByCategory(Long id) {
        List<Product> productsAnswer = new ArrayList<Product>();
        List<Product> products = productRespository.findAll();
        for (Product product : products) {
            if (product.getCategory().getId() == id) {
                productsAnswer.add(product);
            }
        }
        return productsAnswer;
    }

}
