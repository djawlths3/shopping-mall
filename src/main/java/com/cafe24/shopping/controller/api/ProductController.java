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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController()
@RequestMapping("/api/product")
@Api(value = "ProductController", description = "상품 컨트롤러")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ApiOperation(value = "관리자 상품 등록")
	public JSONResult productAdd(@RequestBody ProductVo productVo) {
		ProductVo vo = productService.productRaise(productVo);
		return JSONResult.success(vo);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ApiOperation(value = "상품 리스트(전체,검색)")
	public JSONResult productList(@RequestBody ProductVo productVo) {
		List<ProductVo> li = productService.productList(productVo);
		return JSONResult.success(li);
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	@ApiOperation(value = "상품 상세정보")
	public JSONResult productDetail(@RequestBody ProductVo productVo) {
		List<ProductVo> li = productService.productDetail(productVo);
		return JSONResult.success(li);
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.PUT)
	@ApiOperation(value = "관리자 상품 수정")
	public JSONResult productModify(@RequestBody ProductVo productVo) {
		Boolean tf = productService.productModify(productVo);
		return JSONResult.success(tf);
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.DELETE)
	@ApiOperation(value = "관리자 상품 삭제")
	public JSONResult productRemove(@RequestBody ProductVo productVo) {
		Boolean tf = productService.productRemove(productVo);
		return JSONResult.success(tf);
	}
	
	@RequestMapping(value = "/stock/add", method = RequestMethod.POST)
	@ApiOperation(value = "관리자 상품 수량(옵션) 등록")
	public JSONResult stockAdd(@RequestBody ProductVo productVo) {
		Boolean tf = productService.stockAdd(productVo);
		return JSONResult.success(tf);
	}
	
	@RequestMapping(value = "/stock/modify", method = RequestMethod.PUT)
	@ApiOperation(value = "관리자 상품 수량(옵션) 수정")
	public JSONResult stockModify(@RequestBody ProductVo productVo) {
		Boolean tf = productService.stockModify(productVo);
		return JSONResult.success(tf);
	}
	
	@RequestMapping(value = "/stock/remove", method = RequestMethod.DELETE)
	@ApiOperation(value = "관리자 상품 수량(옵션) 삭제")
	public JSONResult stockRemove(@RequestBody ProductVo productVo) {
		Boolean tf = productService.stockRemove(productVo);
		return JSONResult.success(tf);
	}
	
	@RequestMapping(value = "/overlap", method = RequestMethod.POST)
	@ApiOperation(value = "관리자 상품 중복검사")
	public JSONResult productOverlap(@RequestBody ProductVo productVo) {
		Boolean tf = productService.productOverlap(productVo);
		return JSONResult.success(tf);
	}
	
	@RequestMapping(value = "/stock/overlap", method = RequestMethod.POST)
	@ApiOperation(value = "관리자 상품 옵션 중복검사")
	public JSONResult stockOverlap(@RequestBody ProductVo productVo) {
		Boolean tf = productService.stockOverlap(productVo);
		return JSONResult.success(tf);
	}

}