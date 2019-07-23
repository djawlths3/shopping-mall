package com.cafe24.shopping.repository;

import java.util.List;

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
	
	public void insertPayment(OrderVo orderVo) {
		sqlSession.insert("order.insertPayment", orderVo);
	}

	public List selectList(OrderVo orderVo) {
		List li = sqlSession.selectList("order.selectList", orderVo);
		return li;
	}

	public List selectListAll(OrderVo orderVo) {
		List li = sqlSession.selectList("order.selectListAll", orderVo);
		return li;
	}

	public Boolean update(OrderVo orderVo) {
		return sqlSession.update("order.update", orderVo) > 0;
	}

	public OrderVo select(OrderVo orderVo) {
		OrderVo vo = sqlSession.selectOne("order.select", orderVo);
		return vo;
	}

	public boolean quantityCheck(OrderVo orderVo) {
		return sqlSession.update("order.quantityCheck", orderVo) > 0;
	}

	
	
}
