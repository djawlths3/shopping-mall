package com.cafe24.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shopping.repository.OrderDao;
import com.cafe24.shopping.vo.OrderVo;



@Service
public class OrderService {
	@Autowired
	private OrderDao orderDao;

	public OrderVo orderAdd(OrderVo orderVo) {
		if(orderDao.insert(orderVo)) {
			if(orderDao.insertProduct(orderVo)) {
				return orderVo;
			}			
		}
		return null;
	}

	
	
}
