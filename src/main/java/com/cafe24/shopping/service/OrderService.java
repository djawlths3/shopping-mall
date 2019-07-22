package com.cafe24.shopping.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

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

	public OrderVo orderAddBascket(OrderVo orderVo) {
		List<HashMap<String, Object>> li = orderVo.getBascketProduct();
		if(orderDao.insert(orderVo)) {
			for(HashMap<String, Object> mp : li) {
				orderVo.setQuantity((int) mp.get("quantity"));
				orderVo.setSize((String)mp.get("size"));
				orderVo.setColor((String)mp.get("color"));
				orderVo.setPrice((int)mp.get("price"));
				orderVo.setProductNo((int)mp.get("productNo"));
				orderDao.insertProduct(orderVo);
			}		
			return orderVo;
		}
		return null;
	}

	
	
}
