package com.cafe24.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shopping.repository.BascketDao;
import com.cafe24.shopping.vo.BascketVo;


@Service
public class BascketService {
	@Autowired
	private BascketDao bascketDao;

	public BascketVo bascketRaise(BascketVo bascketVo) {
		if(bascketDao.bascketOverlap(bascketVo)) {
			if(bascketDao.insert(bascketVo)) {
				bascketDao.insertBaskcetManage(bascketVo);
				return bascketVo;
			}
		}else {
			bascketDao.insertBaskcetManage(bascketVo);
			return bascketVo;
		}	
		return null;
	}

	public List<BascketVo> bascketList(BascketVo bascketVo) {
		List<BascketVo> li = bascketDao.selectList(bascketVo);
		return li;
	}

	public Boolean bascketModify(BascketVo bascketVo) {
		Boolean tf = bascketDao.update(bascketVo);
		return tf;
	}

	public Boolean bascketRemove(BascketVo bascketVo) {
		Boolean tf = bascketDao.delete(bascketVo);
		return tf;
	}

	

	
}
