package com.cafe24.shopping.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shopping.vo.OrderVo;

@Repository
public class OrderDao {
	
	@Autowired
	private SqlSession sqlSession;

	public Boolean insert(OrderVo orderVo) {
		return (sqlSession.insert("order.insert", orderVo) > 0);
	}

	public Boolean insertProduct(OrderVo orderVo) {
		return (sqlSession.insert("order.insertProduct", orderVo) > 0);
	}
	
}
