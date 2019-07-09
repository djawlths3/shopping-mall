package com.cafe24.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shopping.repository.UserDao;
import com.cafe24.shopping.vo.UserVo;


@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	

	public UserVo getUser(String email) {
		UserVo userVo = userDao.get(email);
		return userVo;
	}

	
	
}
