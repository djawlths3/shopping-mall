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
public class UserControllerTest {
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private UserService userService; 
	
	
	
	@Before	
	public void setup() {
		mockMvc = MockMvcBuilders.
			webAppContextSetup(webApplicationContext).
			build();
	}

	@Test
	public void testDIuserService() {
		assertNotNull(userService.getUser("djawlths4@naver.com"));
	}

	@Test
	public void testFetchUserList() throws Exception {
		ResultActions resultAction = mockMvc.perform(get("/api/user/list/{no}", 1L).contentType(MediaType.APPLICATION_JSON));
		
		resultAction.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.result",is("success")))
		//.andExpect(jsonPath("$.data",hasSize(1)))
		.andExpect(jsonPath("$.data.no",is(1)))
		.andExpect(jsonPath("$.data.name",is("엄기윤")))
		.andExpect(jsonPath("$.data.password",is("1234")))
		.andExpect(jsonPath("$.data.gender",is("female")));
	}
	
	
	public void testInsertUser() throws Exception {
		UserVo vo = new UserVo();
		//Mockito.when(voMock.getNo2()).thenReturn(10L);
		//Long no = (Long)voMock.getNo2();
		vo.setName("기윤");
		vo.setEmail("bc@bc.com");
		vo.setPassword("1234");
		vo.setGender("female");
		ResultActions resultAction = mockMvc.perform(post("/api/user/add").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultAction.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.data.name",is(vo.getName())))
		.andExpect(jsonPath("$.data.password",is(vo.getPassword())))
		.andExpect(jsonPath("$.data.gender",is(vo.getGender())));;

	}
	
	
	@Test
	public void testDeleteUser() throws Exception {
	       Map<String,Object> map=new HashMap<String,Object>();
	       map.put("no",3L);
	       map.put("password","1234");
	       
	       ResultActions resultActions = mockMvc 
	                .perform(delete("/api/guestbook/delete").contentType(MediaType.APPLICATION_JSON)
	                      .content(new Gson().toJson(map)));
	       resultActions.andExpect(status().isOk()).andDo(print()).
	          andExpect(jsonPath("$.result",is("success")))
	         .andExpect(jsonPath("$.data[0].no",is(1)))
	          .andExpect(jsonPath("$.data[0].name",is("user1")))
	         ;
	    }
}