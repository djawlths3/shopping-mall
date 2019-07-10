package com.cafe24.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shopping.repository.UserDao;
import com.cafe24.shopping.vo.UserVo;


@Service
public class UserService2 {
	@Autowired
	private UserDao userDao;
	

	public UserVo getUser(String email) {
		UserVo userVo = userDao.get(email);
		return userVo;
	}


	public UserVo addUser(UserVo userVo) {
		boolean b = userDao.set(userVo);
		UserVo vo = null;
		if (b) {
			vo = getUser(userVo.getEmail());
		}
		return vo;
	}


	public UserVo delUser(UserVo userVo) {
		
		return null;
	}


	public List<UserVo> getUserList() {
		
		return null;
	}

	
	
	
}
