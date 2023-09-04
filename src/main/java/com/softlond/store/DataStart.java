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
    Category frutasYVerduras = new Category("Frutas y Verduras");
    Category lacteos = new Category("Lácteos");
    Category carnesYPescados = new Category("Carnes y Pescados");
    Category granosYCereales = new Category("Granos y Cereales");
    Category panaderiaYReposteria = new Category("Panadería y Repostería");

    Product product1 = new Product();
    product1.setName("Manzana");
    product1.setPrice(1000F);
    product1.setCategory(frutasYVerduras);
    product1.setStock(500);

    Product product2 = new Product("Plátano", 1000F, 30, frutasYVerduras);
    Product product3 = new Product("Zanahoria", 1000F, 30, frutasYVerduras);
    Product product4 = new Product("Tomate", 1000F, 30, frutasYVerduras);
    Product product5 = new Product("Lechuga", 1000F, 30, frutasYVerduras);
    Product product6 = new Product("Leche", 1000F, 30, lacteos);
    Product product7 = new Product("Queso", 1000F, 30, lacteos);
    Product product8 = new Product("Mantequilla", 1000F, 30, lacteos);
    Product product9 = new Product("Pollo", 1000F, 30, carnesYPescados);
    Product product10 = new Product("Ternera", 1000F, 30, carnesYPescados);
    Product product11 = new Product("Cerdo", 1000F, 30, carnesYPescados);
    Product product12 = new Product("Salmón", 1000F, 30, carnesYPescados);
    Product product13 = new Product("Arroz", 1000F, 30, granosYCereales);
    Product product14 = new Product("Pasta", 1000F, 30, granosYCereales);
    Product product15 = new Product("Cereales", 1000F, 30, granosYCereales);
    Product product16 = new Product("Pan blanco", 1000F, 30, panaderiaYReposteria);
    Product product17 = new Product("Galletas", 1000F, 30, panaderiaYReposteria);
    Product product18 = new Product("Donas", 1000F, 30, panaderiaYReposteria);

    categoryRepository.save(frutasYVerduras);
    categoryRepository.save(lacteos);
    categoryRepository.save(carnesYPescados);
    categoryRepository.save(granosYCereales);
    categoryRepository.save(panaderiaYReposteria);

    productRespository.save(product1);
    productRespository.save(product2);
    productRespository.save(product3);
    productRespository.save(product4);
    productRespository.save(product5);
    productRespository.save(product6);
    productRespository.save(product7);
    productRespository.save(product8);
    productRespository.save(product9);
    productRespository.save(product10);
    productRespository.save(product11);
    productRespository.save(product12);
    productRespository.save(product13);
    productRespository.save(product14);
    productRespository.save(product15);
    productRespository.save(product16);
    productRespository.save(product17);
    productRespository.save(product18);

  }

}
