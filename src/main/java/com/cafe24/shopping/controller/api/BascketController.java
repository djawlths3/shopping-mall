package com.cafe24.shopping.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shopping.dto.JSONResult;
import com.cafe24.shopping.service.BascketService;
import com.cafe24.shopping.vo.BascketVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController()
@RequestMapping("/api/bascket")
@Api(value = "BascketController", description = "장바구니 컨트롤러")
public class BascketController {

	
	@Autowired
	private BascketService bascketService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ApiOperation(value = "장바구니 상품추가")
	public JSONResult bascketAdd(@RequestBody BascketVo bascketVo) {
		BascketVo vo = bascketService.bascketRaise(bascketVo);
		return JSONResult.success(vo);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ApiOperation(value = "장바구니 상품 목록")
	public JSONResult bascketList(@RequestBody BascketVo bascketVo) {
		List<BascketVo> li = bascketService.bascketList(bascketVo);
		return JSONResult.success(li);
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.PUT)
	@ApiOperation(value = "장바구니 상품 수량 수정")
	public JSONResult bascketModify(@RequestBody BascketVo bascketVo) {
		Boolean tf = bascketService.bascketModify(bascketVo);
		return JSONResult.success(tf);
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.DELETE)
	@ApiOperation(value = "장바구니 상품 삭제")
	public JSONResult bascketRemove(@RequestBody BascketVo bascketVo) {
		Boolean tf = bascketService.bascketRemove(bascketVo);
		return JSONResult.success(tf);
	}
	
	@RequestMapping(value = "/removeAll", method = RequestMethod.DELETE)
	@ApiOperation(value = "장바구니 삭제")
	public JSONResult bascketRemoveAll(@RequestBody BascketVo bascketVo) {
		Boolean tf = bascketService.bascketRemoveAll(bascketVo);
		return JSONResult.success(tf);
	}
}