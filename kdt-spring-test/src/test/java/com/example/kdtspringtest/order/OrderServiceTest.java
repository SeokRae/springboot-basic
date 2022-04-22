package com.example.kdtspringtest.order;

import com.example.kdtspringtest.voucher.FixedAmountVoucher;
import com.example.kdtspringtest.voucher.MemoryVoucherRepository;
import com.example.kdtspringtest.voucher.VoucherService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class OrderServiceTest {

	static class OrderRepositoryStub implements OrderRepository {
		@Override
		public Order insert(Order order) {
			return null;
		}
	}

	@Test
	@DisplayName("오더가 생성되야한다. (stub)")
	void createOrder() {
		// Given
		var voucherRepository = new MemoryVoucherRepository();
		var fixedAmountVoucher = new FixedAmountVoucher(UUID.randomUUID(), 100);
		voucherRepository.insert(fixedAmountVoucher);
		var sut = new OrderService(new VoucherService(voucherRepository), new OrderRepositoryStub());

		// When
		var order = sut.createOrder(UUID.randomUUID(), List.of(new OrderItem(UUID.randomUUID(), 200, 1)), fixedAmountVoucher.getVoucherId());

		// Then
		assertThat(order.totalAmount()).isEqualTo(100L);
		assertThat(order.getVoucher().isEmpty()).isFalse();
		assertThat(order.getVoucher().get().getVoucherId()).isEqualTo(fixedAmountVoucher.getVoucherId());
		assertThat(order.getOrderStatus()).isEqualTo(OrderStatus.ACCEPTED);
	}

	@Test
	@DisplayName("오더가 생성되야한다. (mock)")
	void createOrderByMock() {
		// Given
		var voucherServiceMock = mock(VoucherService.class);
		var orderRepositoryMock = mock(OrderRepository.class);
		var fixedAmountVoucher = new FixedAmountVoucher(UUID.randomUUID(), 100);
		when(voucherServiceMock.getVoucher(fixedAmountVoucher.getVoucherId())).thenReturn(fixedAmountVoucher);
		var sut = new OrderService(voucherServiceMock, orderRepositoryMock);

		// When
		var order = sut.createOrder(
				UUID.randomUUID(),
				List.of(new OrderItem(UUID.randomUUID(), 200, 1)),
				fixedAmountVoucher.getVoucherId());

		// Then
		assertThat(order.totalAmount()).isEqualTo(100L);
		assertThat(order.getVoucher().isEmpty()).isFalse();
		var inOrder = inOrder(voucherServiceMock, orderRepositoryMock);
		inOrder.verify(voucherServiceMock).getVoucher(fixedAmountVoucher.getVoucherId());
		inOrder.verify(orderRepositoryMock).insert(order);
		inOrder.verify(voucherServiceMock).useVoucher(fixedAmountVoucher);

	}


}