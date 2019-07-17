package com.cafe24.shopping.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shopping.dto.JSONResult;
import com.cafe24.shopping.service.BascketService;
import com.cafe24.shopping.vo.BascketVo;


@RestController()
@RequestMapping("/api/bascket")
public class BascketController {

	
	@Autowired
	private BascketService bascketService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public JSONResult bascketAdd(@RequestBody BascketVo bascketVo) {
		BascketVo vo = bascketService.bascketRaise(bascketVo);
		return JSONResult.success(vo);
	}
	
}