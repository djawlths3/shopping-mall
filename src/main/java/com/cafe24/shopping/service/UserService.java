package com.cafe24.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cafe24.shopping.repository.UserDao;
import com.cafe24.shopping.vo.UserVo;


@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	

	public UserVo addUser(UserVo joinVo) {
		UserVo vo = new UserVo();
		vo.setNo(1L);
		vo.setId(joinVo.getId());
		vo.setAddress(joinVo.getAddress());
		vo.setAddressDetail(joinVo.getAddressDetail());
		vo.setPassword(joinVo.getPassword());
		vo.setName(joinVo.getName());
		return vo;
	}



	public Boolean login(UserVo userVo) {
		return true;
	}



	public Boolean findId(UserVo userVo) {
		return true;
	}



	public Boolean findPw(UserVo userVo) {
		return true;
	}

	
}
