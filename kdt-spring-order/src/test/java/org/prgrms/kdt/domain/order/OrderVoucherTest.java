package org.prgrms.kdt.domain.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.prgrms.kdt.domain.voucher.FixedAmountVoucher;
import org.prgrms.kdt.domain.voucher.PercentDiscountVoucher;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class OrderVoucherTest {
	private UUID orderId;
	private UUID customerId;
	private UUID productId;

	@BeforeEach
	void setUp() {
		orderId = UUID.randomUUID();
		customerId = UUID.randomUUID();
		productId = UUID.randomUUID();
	}

	@DisplayName("주문 상품 할인 미적용 확인 테스트")
	@Test
	void testCase1() {
		List<OrderItem> sampleOrderItems = List.of(new OrderItem(productId, 1000L, 10));

		Order actual = new Order(orderId, customerId, sampleOrderItems);

		assertThat(actual.totalAmount()).isEqualTo(10000L);
	}

	@DisplayName("주문 상품 고정 할인 적용 테스트")
	@Test
	void testCase2() {
		List<OrderItem> sampleOrderItems = List.of(new OrderItem(productId, 1000L, 10));

		UUID voucherId = UUID.randomUUID();

		Order actual = new Order(orderId, customerId, sampleOrderItems, new FixedAmountVoucher(voucherId, 10L));

		assertThat(actual.totalAmount()).isEqualTo(9990L);
	}

	@DisplayName("주문 상품 비율 할인 적용 테스트")
	@Test
	void testCase3() {
		List<OrderItem> sampleOrderItems = List.of(new OrderItem(productId, 1000L, 10));

		UUID voucherId = UUID.randomUUID();

		Order actual = new Order(orderId, customerId, sampleOrderItems, new PercentDiscountVoucher(voucherId, 10L));

		assertThat(actual.totalAmount()).isEqualTo(9000L);
	}
}