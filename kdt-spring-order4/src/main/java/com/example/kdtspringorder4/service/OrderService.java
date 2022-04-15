package com.example.kdtspringorder4.service;

import com.example.kdtspringorder4.domain.order.Order;
import com.example.kdtspringorder4.domain.order.OrderItem;
import com.example.kdtspringorder4.domain.voucher.Voucher;
import com.example.kdtspringorder4.exception.InsertOrderFailException;
import com.example.kdtspringorder4.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {
	private final VoucherService voucherService;
	private final OrderRepository orderRepository;

	public OrderService(VoucherService voucherService, OrderRepository orderRepository) {
		this.voucherService = voucherService;
		this.orderRepository = orderRepository;
	}

	public Order createOrder(UUID customerId, List<OrderItem> orderItems) {
		Order order = new Order(UUID.randomUUID(), customerId, orderItems);
		return orderRepository.insert(order);
	}

	public Order createOrder(UUID customerId, List<OrderItem> orderItems, UUID voucherId) {
		Voucher voucher = voucherService.getVoucher(voucherId);
		Order order = new Order(UUID.randomUUID(), customerId, orderItems, voucher);
		return Optional.of(orderRepository.insert(order))
				.map(generatedOrder -> {
					voucherService.useVoucher(voucher);
					return generatedOrder;
				})
				.orElseThrow(InsertOrderFailException::new);
	}

}
