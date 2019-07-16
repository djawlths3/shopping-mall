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
		vo.setCategoryName("반");
		vo.setColor("red");
		vo.setPrice(7000);
		vo.setProductEtc("상품입니다.아주이뻐요");
		vo.setProductName("모시반팔");
		vo.setQuantity(10);
		vo.setSize("M");
		// 상품 이미지 
		// vo.setImgEtc("img입니다");
		// vo.setPath("D:/img");
		// vo.setSortNo(1);
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	
	@Test
	public void 테스트01_카테고리삭제() throws Exception {
		mockMvc.perform(post("/api/product/category/removeAll").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	@Test
	public void 테스트02_카테고리등록수정() throws Exception {	
		ResultActions resultAction = mockMvc.perform(post("/api/product/category/raise").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		MvcResult result = resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("success")))
		.andReturn();	
		//카테고리 등록 후 카테고리 이름 수정
		JsonObject elementData = JsonTrans.JsonToObject(result);
		vo.setCategoryNo(elementData.get("categoryNo").getAsLong());
		카테고리수정(vo);		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void 카테고리수정(ProductVo productVo) throws Exception {	
		productVo.setCategoryName("반팔");
		ResultActions resultAction = mockMvc.perform(post("/api/product/category/modify").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(productVo)));
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result",is("success")));				
	}
}