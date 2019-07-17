package com.cafe24.shopping.repository;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shopping.vo.BascketVo;


@Repository
public class BascketDao {
	
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private DataSource datasource;
	
	public Boolean insert(BascketVo bascketVo) {
		return (sqlSession.insert("bascket.insert", bascketVo) > 0);
	}

	public void insertBaskcetManage(BascketVo bascketVo) {
		sqlSession.insert("bascket.insertBascketManage", bascketVo);
		
	}


}
