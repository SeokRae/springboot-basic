package com.example.kdtspringtest;

import com.example.kdtspringtest.order.OrderItem;
import com.example.kdtspringtest.order.OrderService;
import com.example.kdtspringtest.order.OrderStatus;
import com.example.kdtspringtest.voucher.FixedAmountVoucher;
import com.example.kdtspringtest.voucher.VoucherRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.notNullValue;

@SpringJUnitConfig
@ActiveProfiles("test")
class KdtSpringContextTests {

	@Configuration
	@ComponentScan(
			basePackages = {"com.example.kdtspringtest.voucher", "com.example.kdtspringtest.order"}
	)
	static class Config {
	}

	@Autowired
	ApplicationContext context;

	@Autowired
	OrderService orderService;

	@Autowired
	VoucherRepository voucherRepository;

	@Test
	@DisplayName("applicationContext가 생성 되야한다.")
	void testApplicationContext() {
		assertThat(context).isNotNull();
	}

	@Test
	@DisplayName("VoucherRepository가 빈으로 등록되어 있어야 한다.")
	void testVoucherRepositoryCreation() {
		var bean = context.getBean(VoucherRepository.class);
		assertThat(bean).isNotNull();
	}

	@Test
	@DisplayName("orderService를 사용해서 주문을 생성할 수 있다.")
	void testOrderService() {
		// Given
		var fixedAmountVoucher = new FixedAmountVoucher(UUID.randomUUID(), 100);
		voucherRepository.insert(fixedAmountVoucher);

		// When
		var order = orderService.createOrder(
				UUID.randomUUID(),
				List.of(new OrderItem(UUID.randomUUID(), 200, 1)),
				fixedAmountVoucher.getVoucherId());

		// Then
		assertThat(order.totalAmount()).isEqualTo(100L);
		assertThat(order.getVoucher().isEmpty()).isFalse();
		assertThat(order.getVoucher().get().getVoucherId()).isEqualTo(fixedAmountVoucher.getVoucherId());
		assertThat(order.getOrderStatus()).isEqualTo(OrderStatus.ACCEPTED);
	}

}
