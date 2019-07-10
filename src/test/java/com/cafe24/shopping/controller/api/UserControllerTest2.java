package com.cafe24.shopping.controller.api;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.config.web.TestWebConfig;
import com.cafe24.shopping.config.AppConfig;
import com.cafe24.shopping.service.UserService2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class, TestWebConfig.class})
@WebAppConfiguration
public class UserControllerTest2 {
	
	@Before
	public void setUp() {
		System.out.println("@before");
	}
	@Test
	public void myBTest() {
		System.out.println("@test:B");
	}
	@After
	public void tearDown() {
		System.out.println("@after");
	}
	
	
	
	@Test
	public void myCTest() {
		System.out.println("@test:C");
	}
	
}