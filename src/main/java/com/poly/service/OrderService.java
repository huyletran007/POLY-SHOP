package com.poly.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.poly.entity.Order;
import com.poly.entity.Product;

@Service
public interface OrderService {
	Order create(JsonNode orderData);

	Order findById(Integer id);

	List<Order> findByUsername(String username);

	Long getToDayOrder();

	Long totalOrder();

	List<Object[]> getRevenueLast7Days();

	List<Order> findAll();
	
	Page<Order> findAll(Pageable pageable);
	
//	Boolean setOrderAvai(Integer id);
}
