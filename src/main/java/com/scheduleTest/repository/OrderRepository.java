package com.scheduleTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scheduleTest.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
