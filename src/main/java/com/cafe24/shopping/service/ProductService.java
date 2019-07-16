package com.cafe24.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shopping.repository.ProductDao;
import com.cafe24.shopping.vo.ProductVo;



@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;

	public ProductVo categoryRaise(ProductVo productVo) {		
		Boolean tf = productDao.categoryInsert(productVo);
		if( tf ) {
			return productVo;
		}
		return null;
	}

	public Boolean categoryRemoveAll() {
		return productDao.categoryAllDelete();
	}

	public ProductVo categoryModify(ProductVo productVo) {
		Boolean tf = productDao.categoryUpdate(productVo);
		if( tf ) {
			return productVo;
		}
		return null;
	}

	public Boolean categoryDelete(ProductVo productVo) {
		Boolean tf = productDao.categoryDelete(productVo);
		return tf;
	}
	
	
	
}
