package com.scheduleTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scheduleTest.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
