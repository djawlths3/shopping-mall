package com.cafe24.senario;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.cafe24.shopping.controller.api.유저테스트;

import junit.framework.TestSuite;

@RunWith(Suite.class)
@SuiteClasses({
	유저테스트.class
})
public class 로그인시나리오 {
	public static Test suite() {
		return (Test) new TestSuite("회원 주문 시나리오 테스트");
	}
}
