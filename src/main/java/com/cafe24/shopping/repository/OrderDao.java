package com.cafe24.shopping.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao {
	
	@Autowired
	private SqlSession sqlSession;
	
}