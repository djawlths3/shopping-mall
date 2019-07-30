package com.cafe24.shopping.controller.api;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
		vo.setPrice(127000);
		vo.setProductEtc("테스트 입니다");
		vo.setProductName("간디작살안경");
		vo.setQuantity(999);
		vo.setColor("골드");
		vo.setSize("머리56호");
		vo.setCategoryNo(7);
		// 상품 이미지 
		// vo.setImgEtc("img입니다");
		// vo.setPath("D:/img");
		// vo.setSortNo(1);
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	
	@Test
	public void 테스트02_상품등록() throws Exception {	
		ResultActions resultAction = mockMvc.perform(post("/api/product/add").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		MvcResult result = resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("success")))
		.andReturn();	
		
	}
	
	
	@Test
	public void 테스트03_상품리스트() throws Exception {
		// 상품 리스트
		ResultActions resultAction = mockMvc.perform(get("/api/product/list").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("success")));	
		
		// 상품정렬
		vo.setProductName(null);
		vo.setProductSort("priceD");
		resultAction = mockMvc.perform(get("/api/product/list").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("success")));	
		
		// 상품 이름 검색
		vo.setProductName("꽃");
		resultAction = mockMvc.perform(get("/api/product/list").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("success")));	
		
		// 카테고리 별 검색
		vo.setCategoryNo(1);
		resultAction = mockMvc.perform(get("/api/product/list").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("success")));	
		
	}
	
	
	@Test
	public void 테스트04_상품상세정보() throws Exception {	
		vo.setProductNo(1);
		ResultActions resultAction = mockMvc.perform(get("/api/product/detail").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("success")));	
		
	}
	
	
	@Test
	public void 테스트05_상품수정() throws Exception {	
		vo.setProductNo(1);
		vo.setColor("blue");
		vo.setProductName("꽃그림반팔");
		ResultActions resultAction = mockMvc.perform(put("/api/product/modify").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("success")));	
		
	}
	
	
	@Test
	public void 테스트06_상품삭제() throws Exception {	
		vo.setProductNo(1);
		ResultActions resultAction = mockMvc.perform(delete("/api/product/remove").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("success")));	
		
	}
	
	
	@Test
	public void 테스트07_재고추가() throws Exception {	
		vo.setProductNo(5);
		vo.setQuantity(105);
		vo.setColor("green");
		vo.setSize("M");
		ResultActions resultAction = mockMvc.perform(post("/api/product/stock/add").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("success")));	
	}
	
	
	@Test
	public void 테스트08_재고수정() throws Exception {	
		vo.setStockNo(1);
		vo.setQuantity(99);
		vo.setColor("black");
		vo.setSize("L");
		ResultActions resultAction = mockMvc.perform(put("/api/product/stock/modify").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("success")));	
	}
	
	
	@Test
	public void 테스트09_재고삭제() throws Exception {	
		vo.setStockNo(5);
		ResultActions resultAction = mockMvc.perform(delete("/api/product/stock/remove").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("success")));	
	}
	
	@Test
	public void 테스트10_상품중복검사() throws Exception {	
		vo.setProductName("간디작살안경");
		ResultActions resultAction = mockMvc.perform(get("/api/product/overlap").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("success")));	
	}
	
	@Test
	public void 테스트11_재고중복검사() throws Exception {	
		vo.setProductNo(1);
		vo.setColor("black");
		vo.setSize("L");
		ResultActions resultAction = mockMvc.perform(get("/api/product/stock/overlap").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("success")));	
	}

}