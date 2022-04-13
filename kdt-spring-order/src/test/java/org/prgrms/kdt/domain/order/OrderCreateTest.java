package org.prgrms.kdt.domain.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.prgrms.kdt.domain.order.Order;
import org.prgrms.kdt.domain.order.OrderItem;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 주문 정보에 대한 도메인은 어떤 부분을 테스트 해야 할까?
 *
 */
class OrderCreateTest {
	private UUID orderId;
	private UUID customerId;
	private UUID productId;

	@BeforeEach
	void setUp() {
		orderId = UUID.randomUUID();
		customerId = UUID.randomUUID();
		productId = UUID.randomUUID();
	}

	@DisplayName("주문정보 생성(주문Id, 고객Id, 주문 아이디)")
	@Test
	void testCase1() {
		List<OrderItem> sampleOrderItems = List.of(new OrderItem(productId, 1000L, 10));

		Order actual = new Order(orderId, customerId, sampleOrderItems);

		Order expected = new Order(orderId, customerId, Collections.emptyList());
		assertThat(actual).isEqualTo(expected);
	}

	@DisplayName("주문정보 생성 및 가격 확인")
	@Test
	void testCase2() {
		List<OrderItem> sampleOrderItems = List.of(new OrderItem(productId, 1000L, 10));

		Order actual = new Order(orderId, customerId, sampleOrderItems);

		assertThat(actual.totalAmount()).isEqualTo(10000L);
	}
}