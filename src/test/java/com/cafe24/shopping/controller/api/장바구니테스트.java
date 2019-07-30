package com.cafe24.shopping.controller.api;


import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
import com.cafe24.shopping.vo.BascketVo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class, TestWebConfig.class})
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class 장바구니테스트 {
	private MockMvc mockMvc;
	private BascketVo vo = new BascketVo();

	@Autowired
	private WebApplicationContext webApplicationContext;

	
	@Before	
	public void setup() {
		vo.setStockNo(2);
		vo.setIp("127.0.0.1");
		vo.setMemberNo(1);
		vo.setQuantity(3);
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	
	@Test
	public void 테스트01_장바구니추가() throws Exception {
		ResultActions resultAction = mockMvc.perform(post("/api/bascket/add").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print());
	}
	
	
	@Test
	public void 테스트02_장바구니조회() throws Exception {
		ResultActions resultAction = mockMvc.perform(get("/api/bascket/list").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print());
	}
	
	
	@Test
	public void 테스트03_장바구니수정() throws Exception {
		vo.setQuantity(13);
		vo.setBascketNo(1);
		ResultActions resultAction = mockMvc.perform(put("/api/bascket/modify").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print());
	}
	
	@Ignore
	@Test
	public void 테스트04_장바구니삭제() throws Exception {
		vo.setBascketNo(1);
		ResultActions resultAction = mockMvc.perform(delete("/api/bascket/remove").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print());
	}
	
	@Ignore
	@Test
	public void 테스트05_장바구니전체삭제() throws Exception {
		vo.setBascketNo(1);
		ResultActions resultAction = mockMvc.perform(delete("/api/bascket/removeAll").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultAction.andExpect(status().isOk()).andDo(print());
	}
}