package com.cafe24.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shopping.repository.CategoryDao;
import com.cafe24.shopping.vo.ProductVo;



@Service
public class CategoryService {
	@Autowired
	private CategoryDao categoryDao;

	public ProductVo categoryRaise(ProductVo productVo) {		
		Boolean tf = categoryDao.categoryInsert(productVo);
		if( tf ) {
			return productVo;
		}
		return null;
	}

	public Boolean categoryRemoveAll() {
		return categoryDao.categoryAllDelete();
	}

	public ProductVo categoryModify(ProductVo productVo) {
		Boolean tf = categoryDao.categoryUpdate(productVo);
		if( tf ) {
			return productVo;
		}
		return null;
	}

	public Boolean categoryDelete(ProductVo productVo) {
		Boolean tf = categoryDao.categoryDelete(productVo);
		return tf;
	}
	
	
	
}
