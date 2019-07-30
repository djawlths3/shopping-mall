package com.cafe24.shopping.controller.api;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

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
	
	private List<HashMap> bascketList = new ArrayList();
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
		vo.setProductName("꽃그림반팔");
		vo.setQuantity(12);
		vo.setSize("M");
		vo.setColor("white");
		vo.setPrice(35000);
		vo.setProductNo(5);

		
		HashMap<String, Object> mp = new HashMap<>();
		mp.put("quantity", 10);
		mp.put("size", "S");
		mp.put("color", "white");
		mp.put("price", 1000);
		mp.put("productNo", 4);
		mp.put("productName", "꽃그림반팔");
		bascketList.add(mp);
		HashMap<String, Object> mp2 = new HashMap<>();
		mp2.put("quantity", 65);
		mp2.put("size", "S");
		mp2.put("color", "red");
		mp2.put("price", 500);
		mp.put("productName", "꽃그림반팔");
		mp2.put("productNo", 5);
		bascketList.add(mp2);
		
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	

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
		vo.setBascketProduct(bascketList);
		ResultActions resultAction = mockMvc.perform(post("/api/order/addBasket").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print());

		//비회원 상품 주문 
		setup();
		vo.setId(null);
		vo.setBascketProduct(bascketList);
		resultAction = mockMvc.perform(post("/api/order/addBasket").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print());
		
	}
	
	

	@Test
	public void 테스트03_주문조회() throws Exception {
		//회원 주문 검색		
		ResultActions resultAction = mockMvc.perform(get("/api/order/search").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print());
		
		//비회원 주문 검색	
		setup();
		vo.setId(null);
		vo.setOrderNo("ORD-190730-00001");
		resultAction = mockMvc.perform(get("/api/order/search").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print());
		
		//전체 주문 보기
		resultAction = mockMvc.perform(get("/api/order/searchAll").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print());

	}
	

	@Test
	public void 테스트04_주문수정운영자() throws Exception {
		//주문 수정
		vo.setOrderNo("ORD-190730-00001");
		vo.setStatus("배송준비중");
		vo.setDeliveryNo("123456789");
		vo.setPaymentComplete("Y");
		ResultActions resultAction = mockMvc.perform(put("/api/order/modify").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print());
	}
}