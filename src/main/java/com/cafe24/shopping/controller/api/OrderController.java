package com.cafe24.shopping.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shopping.service.OrderService;




@RestController()
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

}