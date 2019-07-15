package com.cafe24.shopping.controller.api;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.core.IsNot;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
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
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;;

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
		vo.setPassword("A1a4!#56789");
		vo.setName("엄기윤");
		vo.setAddress("왕십리");
		vo.setAddressDetail("1109동");
		vo.setPhoneNumber("01095590484");
		vo.setEmail("djawlths4@naver.com");		
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Ignore
	@Test
	public void 유저디비삭제() throws Exception {
		mockMvc.perform(post("/api/user/removeAll").contentType(MediaType.APPLICATION_JSON));
	}
	
	@Ignore
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
	

	@Test
	public void 회원가입테스트() throws Exception {	
		ResultActions resultAction = mockMvc.perform(post("/api/user/join").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));

//		resultAction.andExpect(status().isOk()).andDo(print())
//		.andExpect(jsonPath("$.data.name",is(vo.getName())))
//		.andExpect(jsonPath("$.data.password",is(vo.getPassword())));
		
		//회원 가입후 가입한 회원의 번호 세팅
		MvcResult result = resultAction.andExpect(status().isOk())
				.andDo(print())
				.andExpect(jsonPath("$.data.name",is(vo.getName())))
				.andReturn();
		
		String jsonString = result.getResponse().getContentAsString();
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(jsonString);
		JsonObject elementData = (JsonObject)element.getAsJsonObject().get("data");
		vo.setNo(elementData.get("no").getAsLong());
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