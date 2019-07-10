package com.cafe24.shopping.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shopping.dto.JSONResult;
import com.cafe24.shopping.service.UserService2;
import com.cafe24.shopping.vo.UserVo;

@RestController("guestbookAPIController")
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService2 userservice2;
	
	@RequestMapping(value="/list/{no}", method=RequestMethod.GET)
	public JSONResult list(@PathVariable(value="no") int no) {
		UserVo user = userservice2.getUser("djawlths4@naver.com");
		return JSONResult.success(user);
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public JSONResult add(@RequestBody UserVo userVo) {
		UserVo vo = userservice2.addUser(userVo);
		return JSONResult.success(vo);
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.DELETE)
	public JSONResult delete(@RequestBody UserVo userVo) {
		UserVo vo = userservice2.delUser(userVo);
		return JSONResult.success(vo);
	}
	
}