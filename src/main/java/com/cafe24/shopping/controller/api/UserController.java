package com.cafe24.shopping.controller.api;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shopping.dto.JSONResult;
import com.cafe24.shopping.service.UserService;
import com.cafe24.shopping.validator.constraint.ValidPassword;
import com.cafe24.shopping.vo.UserVo;

@RestController()
@RequestMapping("/api/user")
public class UserController {

	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public JSONResult join(@RequestBody @Valid UserVo userVo, BindingResult result) {
		if( result.hasErrors() ) {
			List<ObjectError> list = result.getAllErrors();
			for(ObjectError error : list) {
				return JSONResult.fail(error.getDefaultMessage());
			}				
		}
		UserVo vo = userService.addUser(userVo);
		return JSONResult.success(vo);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public JSONResult login(@RequestBody UserVo userVo) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<UserVo>> validatorResults = validator.validateProperty(userVo, "id");
		if(validatorResults.isEmpty() == false) {
			for(ConstraintViolation<UserVo> validatorResult : validatorResults) {
				return JSONResult.fail(validatorResult.getMessage());				
			}
		}
		UserVo vo = userService.login(userVo);
		if (vo == null ) {
			return JSONResult.fail("아이디 혹은 비밀번호가 잘못되었습니다");
		}
		return JSONResult.success(vo);
	}

	@RequestMapping(value = "/findId", method = RequestMethod.POST)
	public JSONResult findId(@RequestBody UserVo userVo) {
		UserVo vo = userService.findId(userVo);
		if (vo == null ) {
			return JSONResult.fail("아이디가 없습니다.");
		}
		return JSONResult.success(vo);
	}

	@RequestMapping(value = "/findPw", method = RequestMethod.POST)
	public JSONResult findPw(@RequestBody UserVo userVo) {
		UserVo vo = userService.findPw(userVo);
		return JSONResult.success(vo);
	}
	
	@RequestMapping(value = "/certification", method = RequestMethod.POST)
	public JSONResult certification(@RequestBody UserVo userVo) {
		UserVo vo = userService.certification(userVo);
		return JSONResult.success(vo);
	}
	
	@RequestMapping(value = "/modifyPw", method = RequestMethod.POST)
	public JSONResult modifyPw(@RequestBody UserVo userVo) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<UserVo>> validatorResults = validator.validateProperty(userVo, "password");
		if(validatorResults.isEmpty() == false) {
			for(ConstraintViolation<UserVo> validatorResult : validatorResults) {
				return JSONResult.fail(validatorResult.getMessage());				
			}
		}
		if(userService.modifyPw(userVo)) {
			return JSONResult.success("성공");
		}
		return JSONResult.fail("실패");
	}

	@RequestMapping(value = "/checkId", method = RequestMethod.POST)
	public JSONResult checkId(@RequestBody @Valid UserVo userVo) {
		if (userService.checkId(userVo)) {
			return JSONResult.success("사용가능한 아이디 입니다.");
		}
		return JSONResult.fail("중복되는 아이디가 있습니다.");
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public JSONResult modify(@RequestBody @Valid UserVo userVo, BindingResult result) {
		if( result.hasErrors() ) {
			List<ObjectError> list = result.getAllErrors();
			for(ObjectError error : list) {
				return JSONResult.fail(error.getDefaultMessage());
			}				
		}
		return JSONResult.success(userService.modify(userVo));
	}
	
	@RequestMapping(value = "/removeAll", method = RequestMethod.POST)
	public JSONResult removeAll() {
		return JSONResult.success(userService.remove());
	}
}