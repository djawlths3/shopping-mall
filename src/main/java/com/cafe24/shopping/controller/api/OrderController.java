package com.cafe24.shopping.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shopping.dto.JSONResult;
import com.cafe24.shopping.service.OrderService;
import com.cafe24.shopping.vo.OrderVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




@RestController()
@RequestMapping("/api/order")
@Api(value = "OrderController", description = "주문 컨트롤러")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ApiOperation(value = "단일 상품 주문 생성")
	public JSONResult orderAdd(@RequestBody OrderVo orderVo) {
		OrderVo vo = orderService.orderAdd(orderVo);
		return JSONResult.success(vo);
	}
	
	@RequestMapping(value = "/addBasket", method = RequestMethod.POST)
	@ApiOperation(value = "장바구니 상품 주문 생성")
	public JSONResult orderAddBascket(@RequestBody OrderVo orderVo) {
		OrderVo vo = orderService.orderAddBascket(orderVo);
		return JSONResult.success(vo);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ApiOperation(value = "주문조회")
	public JSONResult orderSearch(@RequestBody OrderVo orderVo) {
		List li = orderService.orderSearch(orderVo);
		return JSONResult.success(li);
	}
	
	@RequestMapping(value = "/searchAll", method = RequestMethod.GET)
	@ApiOperation(value = "관리자 주문 조회(전체,검색)")
	public JSONResult orderSearchAll(@RequestBody OrderVo orderVo) {
		List li = orderService.orderSearchAll(orderVo);
		return JSONResult.success(li);
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.PUT)
	@ApiOperation(value = "관리자 주문 내용 수정(상태변경)")
	public JSONResult orderModify(@RequestBody OrderVo orderVo) {
		OrderVo vo = orderService.orderModify(orderVo);
		return JSONResult.success(vo);
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.DELETE)
	@ApiOperation(value = "관리자 주문 삭제(완료)")
	public JSONResult orderRemove(@RequestBody OrderVo orderVo) {
		Boolean tf = orderService.orderRemove(orderVo);
		return JSONResult.success(tf);
	}
}