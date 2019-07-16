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



	public UserVo login(UserVo userVo) {
		UserVo vo = userDao.login(userVo);
		return vo;
	}



	public UserVo findId(UserVo userVo) {
		return userDao.findId(userVo);
	}



	public UserVo findPw(UserVo userVo) {
		return userDao.findPw(userVo);
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



	public UserVo certification(UserVo userVo) {
		UserVo vo = userDao.certification(userVo);
		
		return vo;
	}



	public Boolean modifyPw(UserVo userVo) {
		if(userDao.updatePw(userVo)) {
			userVo.setCertification("test2");
			userDao.certificationModify(userVo);
			return true;
		}
		return false;
	}



	public UserVo modify(UserVo userVo) {
		UserVo vo = null;
		if((userDao.update(userVo) > 0)) {
			vo = userDao.get(userVo);
		}
		return vo;
	}

	
}
