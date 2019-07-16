package com.cafe24.shopping.controller.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shopping.dto.JSONResult;
import com.cafe24.shopping.service.ProductService;
import com.cafe24.shopping.vo.ProductVo;



@RestController()
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	@RequestMapping(value = "/raise", method = RequestMethod.POST)
	public JSONResult productRaise(@RequestBody ProductVo productVo) {
		ProductVo vo = productService.productRaise(productVo);
		return JSONResult.success(vo);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public JSONResult productList(@RequestBody ProductVo productVo) {
		List<ProductVo> li = productService.productList(productVo);
		return JSONResult.success(li);
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	public JSONResult productDetail(@RequestBody ProductVo productVo) {
		List<ProductVo> li = productService.productDetail(productVo);
		return JSONResult.success(li);
	}
	

}