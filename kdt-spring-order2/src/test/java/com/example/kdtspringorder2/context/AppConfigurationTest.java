package com.example.kdtspringorder2.context;

import com.example.kdtspringorder2.domain.order.Order;
import com.example.kdtspringorder2.domain.order.OrderItem;
import com.example.kdtspringorder2.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class AppConfigurationTest {

	@DisplayName("ApplicationContext 관리 주문 생성 테스트")
	@Test
	void testCase1() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);

		UUID customerId = UUID.randomUUID();
		List<OrderItem> orderItems = List.of(new OrderItem(UUID.randomUUID(), 100L, 1));

		OrderService orderService = applicationContext.getBean(OrderService.class);
		Order order = orderService.createOrder(customerId, orderItems);

		assertThat(order.totalAmount()).isEqualTo(100);
	}
}