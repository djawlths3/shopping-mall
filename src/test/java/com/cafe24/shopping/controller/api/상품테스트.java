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
import com.cafe24.shopping.vo.ProductVo;
import com.cafe24.util.JsonTrans;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class, TestWebConfig.class})
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class 상품테스트 {
	private MockMvc mockMvc;
	private ProductVo vo = new ProductVo();

	@Autowired
	private WebApplicationContext webApplicationContext;

	
	@Before	
	public void setup() {
		vo.setColor("red");
		vo.setPrice(7000);
		vo.setProductEtc("상품입니다.아주이뻐요");
		vo.setProductName("꽃반팔");
		vo.setQuantity(10);
		vo.setSize("M");
		vo.setCategoryNo(1);
		// 상품 이미지 
		// vo.setImgEtc("img입니다");
		// vo.setPath("D:/img");
		// vo.setSortNo(1);
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Ignore
	@Test
	public void 테스트02_상품등록() throws Exception {	
		ResultActions resultAction = mockMvc.perform(post("/api/product/raise").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		MvcResult result = resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("success")))
		.andReturn();	
		
	}
	@Test
	public void 테스트03_상품리스트() throws Exception {
		// 상품 리스트
		ResultActions resultAction = mockMvc.perform(post("/api/product/list").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("success")));	
		
		// 상품정렬
		vo.setProductName(null);
		vo.setProductSort("priceD");
		resultAction = mockMvc.perform(post("/api/product/list").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("success")));	
		
		// 상품 이름 검색
		vo.setProductName("꽃");
		resultAction = mockMvc.perform(post("/api/product/list").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("success")));	
		
		// 카테고리 별 검색
		vo.setCategoryNo(1);
		resultAction = mockMvc.perform(post("/api/product/list").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("success")));	
		
	}
	
	@Test
	public void 테스트04_상품상세정보() throws Exception {	
		vo.setProductNo(4);
		ResultActions resultAction = mockMvc.perform(post("/api/product/detail").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("success")));	
		
	}
	
	@Test
	public void 테스트05_상품수정() throws Exception {	
		//테스트 못함 여기부터 시작
		vo.setProductNo(4);
		ResultActions resultAction = mockMvc.perform(post("/api/product/modify").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("success")));	
		
	}

}