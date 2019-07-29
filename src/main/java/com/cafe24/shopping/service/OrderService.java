package com.cafe24.shopping.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.MultiValueMap;

import com.cafe24.shopping.repository.BascketDao;
import com.cafe24.shopping.repository.OrderDao;
import com.cafe24.shopping.vo.OrderVo;


@Transactional(rollbackFor=Exception.class)
@Service
public class OrderService {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private BascketDao bascketDao;
	
	public OrderVo orderAdd(OrderVo orderVo) {
		if(orderDao.check(orderVo)) {
			orderDao.insert(orderVo);
			orderDao.insertProduct(orderVo);
			orderDao.quantityChange(orderVo);
			orderDao.insertPayment(orderVo);
			return orderVo;
		}
		return null;
	}


	public OrderVo orderAddBascket(OrderVo orderVo) {
		List<HashMap<String, Object>> li = orderVo.getBascketProduct();
		for(HashMap<String, Object> mp : li) {
			orderVo.setQuantity((int) mp.get("quantity"));
			orderVo.setSize((String)mp.get("size"));
			orderVo.setColor((String)mp.get("color"));
			orderVo.setPrice((int)mp.get("price"));
			orderVo.setProductNo((int)mp.get("productNo"));
			if(!(orderDao.check(orderVo))) {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return null;
			}
			orderDao.insert(orderVo);
			orderDao.insertProduct(orderVo);
			orderDao.quantityChange(orderVo);				
		}		
		orderDao.insertPayment(orderVo);
		bascketDao.deleteAll((int)orderVo.getBascketNo());
		return orderVo;
	}

	public List orderSearch(OrderVo orderVo) {
		List li = orderDao.selectList(orderVo);
		return li;
	}

	public List orderSearchAll(OrderVo orderVo) {
		List li = orderDao.selectListAll(orderVo);
		return li;
	}

	public OrderVo orderModify(OrderVo orderVo) {
		OrderVo vo = null;
		if(orderDao.update(orderVo)) {
			vo = orderDao.select(orderVo);
		}
		return vo;
	}


	public Boolean orderRemove(OrderVo orderVo) {
		Boolean tf = orderDao.delete(orderVo);
		return tf;
	}

	
	
}
