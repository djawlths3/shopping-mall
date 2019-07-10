package com.cafe24.shopping.repository;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shopping.vo.UserVo;


@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private DataSource datasource;

	public UserVo get(Long no){
		return sqlSession.selectOne("user.getByNo", no);
	}
	
	public UserVo get(String email){
		return sqlSession.selectOne("user.getByEmail", email);
	}

	public Boolean set(UserVo vo) {
		int cnt = sqlSession.insert("user.insert",vo);
		return 1==cnt;
	}

}
