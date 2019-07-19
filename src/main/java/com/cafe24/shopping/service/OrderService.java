package com.cafe24.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shopping.repository.OrderDao;



@Service
public class OrderService {
	@Autowired
	private OrderDao orderDao;

	
	
}
