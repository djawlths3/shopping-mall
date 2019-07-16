package com.cafe24.shopping.controller.api;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.core.IsNot;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.internal.matchers.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.config.web.TestWebConfig;
import com.cafe24.shopping.config.AppConfig;
import com.cafe24.shopping.vo.UserVo;
import com.cafe24.util.JsonTrans;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class, TestWebConfig.class})
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class 유저테스트 {
	private MockMvc mockMvc;
	private UserVo vo = new UserVo();

	@Autowired
	private WebApplicationContext webApplicationContext;

	
	@Before	
	public void setup() {
		// vo = new UserVo();
		vo.setId("djawlths4");
		vo.setPassword("A1a4!#56789");
		vo.setName("엄기윤");
		vo.setAddress("왕십리");
		vo.setAddressDetail("1109동");
		vo.setPhoneNumber("01095590484");
		vo.setEmail("djawlths4@naver.com");		
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	

	@Test
	public void 테스트01_유저디비삭제() throws Exception {
		mockMvc.perform(post("/api/user/removeAll").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	

	@Test
	public void 테스트02_회원가입테스트() throws Exception {	
		//잘못된 아이디(길이부족)
		vo.setId("a");
		ResultActions resultAction = mockMvc.perform(post("/api/user/join").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("fail")));
		//잘못된 아이디(특수문자)
		vo.setId("!@$a");
		resultAction = mockMvc.perform(post("/api/user/join").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction = mockMvc.perform(post("/api/user/join").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("fail")));
		
		//잘못된 비밀번호(길이부족)
		setup();
		vo.setPassword("12345");
		resultAction = mockMvc.perform(post("/api/user/join").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("fail")));
		//잘못된 비밀번호(특수문자 없음)
		vo.setPassword("12345abced");
		resultAction = mockMvc.perform(post("/api/user/join").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("fail")));

		// 잘못된 email(@없음)
		setup();
		vo.setEmail("abcd.com");
		resultAction = mockMvc.perform(post("/api/user/join").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("fail")));


		// 잘못된 핸드폰 정보(문자포함)
		setup();
		vo.setPhoneNumber("12345ㅁ6782");
		resultAction = mockMvc.perform(post("/api/user/join").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("fail")));
		// 잘못된 핸드폰 정보(길이부족)
		vo.setPhoneNumber("010955904");
		resultAction = mockMvc.perform(post("/api/user/join").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("fail")));
		// 잘못된 핸드폰 정보(길이초과)
		vo.setPhoneNumber("0109559048448");
		resultAction = mockMvc.perform(post("/api/user/join").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("fail")));
		
		//회원가입 성공
		setup();
		resultAction = mockMvc.perform(post("/api/user/join").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		MvcResult result = resultAction.andExpect(status().isOk())
						.andDo(print())
						.andExpect(jsonPath("$.data.id",is(vo.getId())))
						.andReturn();
		//회원 가입후 가입한 회원의 번호 세팅
		JsonObject elementData = JsonTrans.JsonToObject(result);
		vo.setNo(elementData.get("no").getAsLong());

	}
	

	@Test
	public void 테스트03_아이디중복체크() throws Exception{
		//중복되는 아이디	
		ResultActions resultAction = mockMvc.perform(post("/api/user/checkId").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("fail")));
		
		//중복 안 되는 아이디
		vo.setId("ddddsass");
		resultAction = mockMvc.perform(post("/api/user/checkId").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("success")));
		
	}
	

	@Test
	public void 테스트04_로그인테스트() throws Exception {
		// 로그인 성공
		ResultActions resultAction = mockMvc.perform(post("/api/user/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("success")));
		
		// 로그인 실패(비밀번호)
		vo.setPassword("1232456!@#e");
		resultAction = mockMvc.perform(post("/api/user/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("fail")));
		
		// 로그인 실패(아이디)
		setup();
		vo.setId("apple1234");
		resultAction = mockMvc.perform(post("/api/user/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("fail")));
		
		// 규격 외 아이디 입력
		setup();
		vo.setId("!@#");
		resultAction = mockMvc.perform(post("/api/user/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk())
		.andExpect(jsonPath("$.message",is("아이디는 특수문자가 들어가지 않게 2~14자 사이로 입력해주세요.")))
		.andDo(print());
	}


	@Test
	public void 테스트05_아이디찾기테스트() throws Exception {
		//아이디 찾기 성공
		ResultActions resultAction = mockMvc.perform(post("/api/user/findId").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.data.id",is("djawlths4")));
		
		//아이디 찾기 실패
		vo.setEmail("aa@bb.com");
		resultAction = mockMvc.perform(post("/api/user/findId").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("fail")));
	}

	@Test
	public void 테스트06_비밀번호찾기테스트() throws Exception {
		//아이디 입력
		ResultActions resultAction = mockMvc.perform(post("/api/user/findPw").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		MvcResult result = resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.data.certification",is("test")))
		.andReturn();
		//인증번호 입력
		JsonObject elementData = JsonTrans.JsonToObject(result);
		vo.setCertification(elementData.get("certification").getAsString());
		resultAction = mockMvc.perform(post("/api/user/certification").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("success")));
		// 비밀번호 수정
		vo.setPassword("1234%678a");
		resultAction = mockMvc.perform(post("/api/user/modifyPw").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("success")));
		// 잘못된 비밀번호 수정
		vo.setPassword("12534");
		resultAction = mockMvc.perform(post("/api/user/modifyPw").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("fail")));
	}
	

	@Test
	public void 테스트07_회원정보수정() throws Exception {
		vo.setPassword("A1a4!#56789");
		vo.setName("개똥이");
		vo.setAddress("철원");
		vo.setAddressDetail("101동");
		vo.setPhoneNumber("01095590484");
		vo.setEmail("djawlths4@naver.com");	
		ResultActions resultAction = mockMvc.perform(post("/api/user/modify").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("success")));

	}
	
}