package com.scheduleTest.service;

import java.util.List;

import com.scheduleTest.entity.Product;

public interface ProductService {

	Product findById(Integer id);
	
	List<Product> findAll();
	
	Product add(Product product);
	
	boolean deleteById(Integer id);
	
	Product update(Product newProduct);
}
