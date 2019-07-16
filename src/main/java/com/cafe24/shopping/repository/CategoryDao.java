package com.cafe24.shopping.repository;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shopping.vo.ProductVo;
import com.cafe24.shopping.vo.UserVo;


@Repository
public class CategoryDao {
	
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private DataSource datasource;
	
	public Boolean categoryInsert(ProductVo productVo) {
		return (sqlSession.insert("category.insert", productVo) > 0 );
	}

	public Boolean categoryAllDelete() {
		return (sqlSession.delete("category.allDelete") > 0);
	}

	public Boolean categoryUpdate(ProductVo productVo) {
		return (sqlSession.update("category.update", productVo) > 0 );
	}
	
	public Boolean categoryDelete(ProductVo productVo) {
		return (sqlSession.delete("category.delete", productVo) > 0 );
	}

	
}
