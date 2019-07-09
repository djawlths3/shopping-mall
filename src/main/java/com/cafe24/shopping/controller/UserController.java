package com.cafe24.shopping.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.shopping.service.UserService;
import com.cafe24.shopping.vo.UserVo;


@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(
		@RequestParam(value="email", required=true, defaultValue="") String email, 
		@RequestParam(value="password", required=true, defaultValue="") String password,
		HttpSession session, Model model) {
		
		UserVo authUser = userService.getUser( "djawlths4@naver.com" );
		if(authUser == null) {
			model.addAttribute("result", "fail");
			return "user/login";
		}
		
		// session 처리
		session.setAttribute("authUser", authUser);
		
		return "redirect:/";
	}


}
