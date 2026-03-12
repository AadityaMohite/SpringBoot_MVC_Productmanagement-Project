package com.Aadi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Aadi.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {


	
}
