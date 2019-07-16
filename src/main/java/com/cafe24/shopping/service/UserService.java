package com.cafe24.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cafe24.shopping.repository.UserDao;
import com.cafe24.shopping.vo.UserVo;


@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	

	public UserVo addUser(UserVo userVo) {
		Boolean tf = userDao.insert(userVo);
		if( !tf ) {
			return null;
		}
		return userVo;
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



	public Boolean remove() {
		Boolean tf = userDao.delete();
		return tf;
	}



	public Boolean checkId(UserVo userVo) {
		UserVo vo = userDao.checkId(userVo.getId());
		if (vo == null) {
			return true;
		}
		return false;
	}

	
}
