package com.example.kdtspringorder4.service;

import com.example.kdtspringorder4.domain.order.Order;
import com.example.kdtspringorder4.domain.order.OrderItem;
import com.example.kdtspringorder4.domain.voucher.DefaultAmountVoucher;
import com.example.kdtspringorder4.domain.voucher.FixedAmountVoucher;
import com.example.kdtspringorder4.domain.voucher.PercentDiscountVoucher;
import com.example.kdtspringorder4.domain.voucher.Voucher;
import com.example.kdtspringorder4.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

	@InjectMocks
	private OrderService orderService;
	@Mock
	private VoucherService voucherService;
	@Mock
	private OrderRepository orderRepository;

	private UUID orderId;
	private UUID customerId;
	private UUID productId;
	private UUID voucherId;
	private List<OrderItem> orderItems;

	@BeforeEach
	void setUp() {
		orderId = UUID.randomUUID();
		customerId = UUID.randomUUID();
		productId = UUID.randomUUID();
		voucherId = UUID.randomUUID();
		orderItems = List.of(new OrderItem(productId, 1000L, 10));
	}

	@DisplayName("주문 생성 서비스 테스트")
	@Test
	void testCase1() {

		Order actual = new Order(orderId, customerId, orderItems);

		given(orderRepository.insert(any())).willReturn(actual);

		Order order = orderService.createOrder(customerId, orderItems);

		assertThat(order).isNotNull();
	}

	@DisplayName("바우처 없이 주문 생성 서비스 테스트")
	@Test
	void testCase1_1() {
		Voucher voucher = new DefaultAmountVoucher();
		Order actual = new Order(orderId, customerId, orderItems, voucher);

		given(orderRepository.insert(any())).willReturn(actual);

		Order order = orderService.createOrder(customerId, orderItems);

		assertThat(order).isNotNull();
		assertThat(order.totalAmount()).isEqualTo(10000L);
	}

	@DisplayName("고정 할인 바우처를 사용하여 주문 생성")
	@Test
	void testCase2() {
		Voucher voucher = new FixedAmountVoucher(voucherId, 10L);
		Order order = new Order(orderId, customerId, orderItems, voucher);

		given(voucherService.getVoucher(voucherId)).willReturn(voucher);
		given(orderRepository.insert(any())).willReturn(order);
		// voucherService 내부 구현 안됨
		Order actual = orderService.createOrder(customerId, orderItems, voucherId);

		verify(voucherService, times(1)).getVoucher(voucherId);
		// verify(orderRepository, times(1)).insert(order); // 내부적으로 UUID를 만들고 있어 mocking 할 수 있는 방법이 있나?
		verify(voucherService, times(1)).useVoucher(voucher);

		assertThat(actual.totalAmount()).isEqualTo(9990L);
	}

	@DisplayName("비율 할인 바우처를 사용하여 주문 생성")
	@Test
	void testCase3() {
		Voucher voucher = new PercentDiscountVoucher(voucherId, 10L);
		Order order = new Order(orderId, customerId, orderItems, voucher);

		given(voucherService.getVoucher(voucherId)).willReturn(voucher);
		given(orderRepository.insert(any())).willReturn(order);
		// voucherService 내부 구현 안됨
		Order actual = orderService.createOrder(customerId, orderItems, voucherId);

		verify(voucherService, times(1)).getVoucher(voucherId);
		// verify(orderRepository, times(1)).insert(order); // 내부적으로 UUID를 만들고 있어 mocking 할 수 있는 방법이 있나?
		verify(voucherService, times(1)).useVoucher(voucher);

		assertThat(actual.totalAmount()).isEqualTo(9000L);
	}
}