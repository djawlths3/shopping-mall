package com.cafe24.shopping.controller.api;


import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.http.MediaType;

import com.cafe24.config.web.TestWebConfig;
import com.cafe24.shopping.config.AppConfig;
import com.cafe24.shopping.vo.OrderVo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class, TestWebConfig.class})
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class 주문테스트 {
	private MockMvc mockMvc;
	private OrderVo vo = new OrderVo();

	@Autowired
	private WebApplicationContext webApplicationContext;

	
	@Before	
	public void setup() {
		vo.setAddress("왕십리");
		vo.setAddressDetail("1109");
		vo.setId("djawlths4");
		vo.setMsg("경비실에 맡겨주세요");
		vo.setName("엄기윤");
		vo.setPassword("1234");
		vo.setPhone("01095590484");
		
		vo.setQuantity(2);
		vo.setSize("m");
		vo.setColor("red");
		vo.setPrice(35000);
		vo.setProductNo(1);
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Ignore
	@Test
	public void 테스트01_상품단품주문() throws Exception {
		//회원 상품 주문 
		vo.setPassword(null);
		ResultActions resultAction = mockMvc.perform(post("/api/order/add").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print());
		// 비회원 상품 주문 
		setup();
		vo.setId(null);
		resultAction = mockMvc.perform(post("/api/order/add").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print());		
	}
	
	@Test
	public void 테스트02_상품장바구니주문() throws Exception {
		//회원 상품 주문 
		vo.setPassword(null);
		ResultActions resultAction = mockMvc.perform(post("/api/order/add").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print());
		// 비회원 상품 주문 
		setup();
		vo.setId(null);
		resultAction = mockMvc.perform(post("/api/order/add").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print());		
	}
}