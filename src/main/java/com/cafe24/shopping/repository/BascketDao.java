package com.cafe24.shopping.repository;

import java.util.HashMap;
import java.util.List;
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

	public Boolean bascketOverlap(BascketVo bascketVo) {
		int result = sqlSession.selectOne("bascket.bascketOverlap", bascketVo);
		return (result == 0);
	}

	public List<BascketVo> selectList(BascketVo bascketVo) {
		List li = sqlSession.selectList("bascket.selectList", bascketVo);
		return li;
	}

	public Boolean update(BascketVo bascketVo) {
		return sqlSession.update("bascket.update", bascketVo) > 0;
	}

	public Boolean delete(BascketVo bascketVo) {
		return sqlSession.delete("bascket.delete", bascketVo) > 0;
	}

	public Boolean deleteAll(int no) {
		return sqlSession.delete("bascket.deleteAll", no) > 0;
	}
}
