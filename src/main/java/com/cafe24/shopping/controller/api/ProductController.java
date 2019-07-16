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
	
	@RequestMapping(value = "/category/removeAll", method = RequestMethod.POST)
	public JSONResult categoryRemoveAll() {
		Boolean tf = productService.categoryRemoveAll();
		return JSONResult.success(tf);
	}
	
	@RequestMapping(value = "/category/raise", method = RequestMethod.POST)
	public JSONResult categoryRaise(@RequestBody ProductVo productVo) {
		ProductVo vo = productService.categoryRaise(productVo);
		return JSONResult.success(vo);
	}
	
	@RequestMapping(value = "/category/modify", method = RequestMethod.POST)
	public JSONResult categoryModify(@RequestBody ProductVo productVo) {
		ProductVo vo = productService.categoryModify(productVo);
		return JSONResult.success(vo);
	}
	
	@RequestMapping(value = "/category/remove", method = RequestMethod.POST)
	public JSONResult categoryRemove(@RequestBody ProductVo productVo) {	
		if(productService.categoryDelete(productVo)) {
			return JSONResult.success("삭제");
		}
		return JSONResult.fail("삭제실패");
	}
	

}