package com.softlond.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.softlond.store.entities.Category;
import com.softlond.store.entities.Product;
import com.softlond.store.repositories.ICategoryRepository;
import com.softlond.store.repositories.IProductRespository;

@Component
public class DataStart implements CommandLineRunner {

  @Autowired
  ICategoryRepository categoryRepository;
  @Autowired
  IProductRespository productRespository;

  @Override
  public void run(String... args) throws Exception {
    Category electronics = new Category("Electronics");
    Category food = new Category("Food");
    Category clothing = new Category("Clothing");
    Category homeAppliances = new Category("Home Appliances");
    Category beautyAndPersonalCare = new Category("Beauty and Personal Care");

    Product product1 = new Product();
    product1.setName("Apple");
    product1.setPrice(1000F);
    product1.setCategory(food);
    product1.setStock(500);

    Product product2 = new Product("fish", 15000F, 30, food);

    categoryRepository.save(food);
    productRespository.save(product1);
    categoryRepository.save(beautyAndPersonalCare);
  }

}
