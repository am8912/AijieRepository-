package com.scheduleTest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.scheduleTest.entity.Invoice;
import com.scheduleTest.entity.Order;
import com.scheduleTest.repository.OrderRepository;
import com.scheduleTest.service.OrderService;

public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	// 查詢單筆
	@Override
	public Order findById(Integer id) {
		Optional<Order> optional = orderRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	// 查詢所有
	@Override
	public List<Order> findAll(){
		return orderRepository.findAll();
	}
	
	// 新增
	@Override
	public Order add(Order order) {
		return orderRepository.save(order);
	}
	
	// 刪除
	@Override
	public boolean deleteById(Integer id) {
		Optional<Order> optional = orderRepository.findById(id);
		if(optional.isPresent()) {
			orderRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	// 修改
	@Override
	public Order update(Integer id, Order newOrder) {
		Optional<Order> optional = orderRepository.findById(id);
		if(optional.isPresent()) {
			Order order = optional.get();
			order.setOrderDate(newOrder.getOrderDate());
			order.setTotalAmount(newOrder.getTotalAmount());
			order.setShippingAddress(newOrder.getShippingAddress());
			order.setPaymentStatus(newOrder.getPaymentStatus());
			order.setOrderStatus(newOrder.getOrderStatus());
			order.setCouponCode(newOrder.getCouponCode());
			order.setTaxAmount(newOrder.getTaxAmount());
			order.setDiscountAmount(newOrder.getDiscountAmount());
			return orderRepository.save(order);
		}
		return	null;	
	}

}
