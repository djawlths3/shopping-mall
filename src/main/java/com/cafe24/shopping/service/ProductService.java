package com.cafe24.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shopping.repository.ProductDao;
import com.cafe24.shopping.vo.ProductVo;



@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;

	public ProductVo productRaise(ProductVo productVo) {
		if( productDao.insert(productVo) ) {
			productDao.insertStock(productVo);
			return productVo;
		}
		return null;
	}

	public List<ProductVo> productList(ProductVo productVo) {
		List li = productDao.selectList(productVo);
		return li;
	}

	public List<ProductVo> productDetail(ProductVo productVo) {
		List li = productDao.selectDetail(productVo);
		return li;
	}


		
	
}
