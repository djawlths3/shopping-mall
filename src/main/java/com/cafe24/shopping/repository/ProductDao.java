package com.cafe24.shopping.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shopping.vo.ProductVo;


@Repository
public class ProductDao {
	
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private DataSource datasource;
	
	public Boolean insert(ProductVo productVo) {
		return (sqlSession.insert("product.insert", productVo) > 0);
	}

	public Boolean insertStock(ProductVo productVo) {
		return (sqlSession.insert("product.insertStock", productVo) > 0);
	}

	public Boolean insertImg(ProductVo productVo) {
		return (sqlSession.insert("product.insertImg", productVo) > 0);
	}

	public List selectList(ProductVo productVo) {
		List li = sqlSession.selectList("product.selectList", productVo);
		return li;
	}

	public List selectDetail(ProductVo productVo) {	
		return sqlSession.selectList("product.selectDetail", productVo);
	}

	public Boolean update(ProductVo productVo) {
		return (sqlSession.update("product.update", productVo) > 0);
	}
	
	
	
}
