package com.scheduleTest.service;

import java.util.List;

import com.scheduleTest.entity.Order;

public interface OrderService {
	

	Order findById(Integer id);
	
	List<Order> findAll();
	
	Order add(Order order);
	
	boolean deleteById(Integer id);
	
	Order update(Order newOrder);
}
