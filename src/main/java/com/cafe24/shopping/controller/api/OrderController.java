package com.cafe24.shopping.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shopping.dto.JSONResult;
import com.cafe24.shopping.service.OrderService;
import com.cafe24.shopping.vo.OrderVo;




@RestController()
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public JSONResult orderAdd(@RequestBody OrderVo orderVo) {
		OrderVo vo = orderService.orderAdd(orderVo);
		return JSONResult.success(vo);
	}
	
	@RequestMapping(value = "/addBasket", method = RequestMethod.POST)
	public JSONResult orderAddBascket(@RequestBody OrderVo orderVo) {
		OrderVo vo = orderService.orderAddBascket(orderVo);
		return JSONResult.success(vo);
	}

}