package com.example.kdtspringorder3;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class A {
	private final B b;

	public A(B b) {
		this.b = b;
	}
}

class B {
	private final A a;

	public B(A a) {
		this.a = a;
	}
}

@Configuration
class CircularConfig {

	@Bean
	public A a(B b) {
		return new A(b);
	}

	@Bean
	public B b(A a) {
		return new B(a);
	}
}

class KdtSpringOrder3ApplicationTests {

	@Test
	void testCase1() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CircularConfig.class);
	}
}
