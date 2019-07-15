package com.cafe24.shopping.controller.api;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.config.web.TestWebConfig;
import com.cafe24.shopping.config.AppConfig;
import com.cafe24.shopping.service.UserService;
import com.cafe24.shopping.vo.UserVo;
import com.google.gson.Gson;;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class, TestWebConfig.class})
@WebAppConfiguration
public class 유저테스트 {
	private MockMvc mockMvc;
	private UserVo vo = new UserVo();
	@Autowired
	private WebApplicationContext webApplicationContext;

	
	@Before	
	public void setup() {
		vo = new UserVo();
		vo.setId("djawlths4");
		vo.setName("엄기윤");
		vo.setEmail("djawlths4@naver.com");
		vo.setPassword("A1a4!#56789");
		vo.setAddress("왕십리");
		vo.setAddressDetail("11-22");
		vo.setPhoneNumber("01095590484");
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void 아이디체크() throws Exception{
		//아이디 정상
		ResultActions resultAction = mockMvc.perform(post("/api/user/check").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk())
		.andDo(print());
		//아이디 비정상
		vo.setPassword("A1a456789");
		resultAction = mockMvc.perform(post("/api/user/check").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isBadRequest())
		.andDo(print());	
	}
	
	@Ignore
	@Test
	public void 회원가입테스트() throws Exception {
		
		ResultActions resultAction = mockMvc.perform(post("/api/user/join").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.data.name",is(vo.getName())))
		.andExpect(jsonPath("$.data.password",is(vo.getPassword())));

	}
	
	@Ignore
	@Test
	public void 로그인테스트() throws Exception {
		
		ResultActions resultAction = mockMvc.perform(post("/api/user/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("success")));
		
		vo.setId("t");
		vo.setPassword("12345e");
		resultAction = mockMvc.perform(post("/api/user/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isBadRequest()).
		andDo(print());

	}
	
	@Ignore
	@Test
	public void 아이디찾기테스트() throws Exception {
		ResultActions resultAction = mockMvc.perform(post("/api/user/find_id").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("success")));

	}

	@Ignore
	@Test
	public void 비밀번호찾기테스트() throws Exception {
		ResultActions resultAction = mockMvc.perform(post("/api/user/find_pw").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("success")));

	}
	
}