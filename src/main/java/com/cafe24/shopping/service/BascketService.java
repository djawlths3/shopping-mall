package com.cafe24.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shopping.repository.BascketDao;
import com.cafe24.shopping.vo.BascketVo;


@Service
public class BascketService {
	@Autowired
	private BascketDao bascketDao;

	public BascketVo bascketRaise(BascketVo bascketVo) {
		if(bascketDao.insert(bascketVo)) {
			bascketDao.insertBaskcetManage(bascketVo);
			return bascketVo;
		}
		return null;
	}

	

	
}
