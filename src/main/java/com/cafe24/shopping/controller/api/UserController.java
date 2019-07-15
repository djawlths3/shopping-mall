package com.cafe24.shopping.controller.api;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
import com.cafe24.shopping.vo.UserVo;

@RestController()
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private MessageSource messagesource;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public JSONResult join(@RequestBody UserVo userVo) {
		UserVo vo = userService.addUser(userVo);
		return JSONResult.success(vo);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<JSONResult> login(@RequestBody UserVo userVo) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<UserVo>> validatorResults = validator.validateProperty(userVo, "id");
		if(validatorResults.isEmpty() == false) {
			String msg = messagesource.getMessage("NotEmpty.userVo.id", null, LocaleContextHolder.getLocale());
			for(ConstraintViolation<UserVo> validatorResult : validatorResults) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(msg));				
			}
		}
		validatorResults = validator.validateProperty(userVo, "password");
		if(validatorResults.isEmpty() == false) {
			for(ConstraintViolation<UserVo> validatorResult : validatorResults) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(validatorResult.getMessage()));				
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(null));
	}

	@RequestMapping(value = "/find_id", method = RequestMethod.POST)
	public JSONResult findId(@RequestBody UserVo userVo) {
		Boolean tf = userService.findId(userVo);
		return JSONResult.success(tf);
	}

	@RequestMapping(value = "/find_pw", method = RequestMethod.POST)
	public JSONResult findPw(@RequestBody UserVo userVo) {
		Boolean tf = userService.findPw(userVo);
		return JSONResult.success(tf);
	}

	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public ResponseEntity<JSONResult> check(@RequestBody @Valid UserVo userVo, BindingResult result) {
		if( result.hasErrors() ) {
			List<ObjectError> list = result.getAllErrors();
			for(ObjectError error : list) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(error.getDefaultMessage()));
			}				
		}
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(null));
	}
}