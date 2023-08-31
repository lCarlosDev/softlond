package com.softlond.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softlond.store.entities.Product;

@Repository
public interface IProductRespository extends JpaRepository<Product, Long> {

}
