package com.cafe24.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.shopping.repository.ProductDao;
import com.cafe24.shopping.vo.ProductVo;


@Transactional(rollbackFor=Exception.class)
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

	public Boolean productModify(ProductVo productVo) {
		Boolean tf = productDao.update(productVo);
		return tf;
	}

	public Boolean productRemove(ProductVo productVo) {
		Boolean tf = productDao.delete(productVo);
		return tf;
	}

	public Boolean stockAdd(ProductVo productVo) {
		return productDao.insertStock(productVo);
	}

	public Boolean stockModify(ProductVo productVo) {
		Boolean tf = productDao.updateStock(productVo);
		return tf;
	}

	public Boolean stockRemove(ProductVo productVo) {
		Boolean tf = productDao.deleteStock(productVo);
		return tf;
	}

	public Boolean productOverlap(ProductVo productVo) {
		Boolean tf = productDao.selectProduct(productVo);
		return tf;
	}

	public Boolean stockOverlap(ProductVo productVo) {
		Boolean tf = productDao.selectStock(productVo);
		return tf;
	}


		
	
}
