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


	public Boolean insert(UserVo vo) {
		int cnt = sqlSession.insert("user.insert",vo);
		return 1==cnt;
	}

	public boolean delete() {
		return (sqlSession.delete("user.deleteAll") > 0);
	}

	public UserVo checkId(String id) {
		return sqlSession.selectOne("user.checkId", id);		
	}

	public UserVo login(UserVo userVo) {
		return sqlSession.selectOne("user.login", userVo);
	}

	public UserVo findId(UserVo userVo) {
		return sqlSession.selectOne("user.findId", userVo);
	}

	public UserVo findPw(UserVo userVo) {
		return sqlSession.selectOne("user.findPw", userVo);
	}

	public UserVo certification(UserVo userVo) {
		return sqlSession.selectOne("user.certification", userVo);
	}

	public int certificationModify(UserVo userVo) {
		return sqlSession.update("user.certificationModify", userVo);
	}

	public Boolean updatePw(UserVo userVo) {
		return (sqlSession.update("user.updatePw", userVo) > 0);
	}

	public int update(UserVo userVo) {
		return sqlSession.update("user.update", userVo);
	}


	public UserVo get(UserVo userVo) {
		return sqlSession.selectOne("user.select", userVo);
	}

}
