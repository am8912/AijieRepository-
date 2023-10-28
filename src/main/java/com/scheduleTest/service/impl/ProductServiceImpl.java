package com.scheduleTest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.scheduleTest.entity.Invoice;
import com.scheduleTest.entity.Product;
import com.scheduleTest.repository.ProductRepository;
import com.scheduleTest.service.ProductService;

public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	// 查詢單筆
	@Override
	public Product findById(Integer id) {
		Optional<Product> optional = productRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	// 查詢所有
	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	// 新增
	@Override
	public Product add(Product product) {
		return productRepository.save(product);
	}

	// 刪除
	@Override
	public boolean deleteById(Integer id) {
		Optional<Product> optional = productRepository.findById(id);
		if (optional.isPresent()) {
			productRepository.deleteById(id);
			return true;
		}
		return false;
	}

	// 修改
	@Override
	public Product update(Integer id, Product newProduct) {
		Optional<Product> optional = productRepository.findById(id);
		if (optional.isPresent()) {
			Product product = optional.get();
			product.setProductName(newProduct.getProductName());
			product.setDescription(newProduct.getDescription());
			product.setCategory(newProduct.getCategory());
			product.setPrice(newProduct.getPrice());
			product.setStockQuantity(newProduct.getStockQuantity());
			product.setManufacturer(newProduct.getManufacturer());
			product.setReleaseDate(newProduct.getReleaseDate());
			product.setRating(newProduct.getRating());
			product.setIsAvailable(newProduct.getIsAvailable());
			return productRepository.save(product);
		}
		return null;
	}

}