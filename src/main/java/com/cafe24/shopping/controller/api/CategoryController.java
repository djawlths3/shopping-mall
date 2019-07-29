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
import com.cafe24.shopping.service.CategoryService;
import com.cafe24.shopping.vo.ProductVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController()
@RequestMapping("/api/category")
@Api(value = "CategoryController", description = "카테고리 컨트롤러")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/removeAll", method = RequestMethod.DELETE)
	@ApiOperation(value = "카테고리 전체 삭제")
	public JSONResult categoryRemoveAll() {
		Boolean tf = categoryService.categoryRemoveAll();
		return JSONResult.success(tf);
	}
	
	@RequestMapping(value = "/raise", method = RequestMethod.POST)
	@ApiOperation(value = "카테고리 등록")
	public JSONResult categoryRaise(@RequestBody ProductVo productVo) {
		ProductVo vo = categoryService.categoryRaise(productVo);
		return JSONResult.success(vo);
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.PUT)
	@ApiOperation(value = "카테고리 이름수정")
	public JSONResult categoryModify(@RequestBody ProductVo productVo) {
		ProductVo vo = categoryService.categoryModify(productVo);
		return JSONResult.success(vo);
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.DELETE)
	@ApiOperation(value = "카테고리 삭제")
	public JSONResult categoryRemove(@RequestBody ProductVo productVo) {	
		if(categoryService.categoryDelete(productVo)) {
			return JSONResult.success("삭제");
		}
		return JSONResult.fail("삭제실패");
	}
	

}