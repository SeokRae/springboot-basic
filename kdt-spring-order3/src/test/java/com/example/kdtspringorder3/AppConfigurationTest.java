package com.example.kdtspringorder3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class AppConfigurationTest {

	@DisplayName("ApplicationContext 조회 테스트")
	@Test
	void testCase1() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
	}
}