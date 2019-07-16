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
		resultAction = mockMvc.perform(post("/api/user/join").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
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
	


	
	@Ignore
	@Test
	public void 로그인테스트() throws Exception {
		
		ResultActions resultAction = mockMvc.perform(post("/api/user/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("success")));
		
		vo.setId("djawl");
		vo.setPassword("12345");
		resultAction = mockMvc.perform(post("/api/user/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk())
		.andExpect(jsonPath("$.message",is("비밀번호는 8자 이상 20자 이하의 알파벳, 숫자, 특수문자를 조합하여 작성해야 합니다.")))
		.andDo(print());
		
		vo.setId("!@#");
		vo.setPassword("123424#21a5");
		resultAction = mockMvc.perform(post("/api/user/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk())
		.andExpect(jsonPath("$.message",is("아이디는 특수문자가 들어가지 않게 2~14자 사이로 입력해주세요.")))
		.andDo(print());

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