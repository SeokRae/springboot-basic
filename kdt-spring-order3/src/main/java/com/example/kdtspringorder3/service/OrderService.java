package com.example.kdtspringorder3.service;

import com.example.kdtspringorder3.domain.order.Order;
import com.example.kdtspringorder3.domain.order.OrderItem;
import com.example.kdtspringorder3.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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
		var order = new Order(UUID.randomUUID(), customerId, orderItems);
		orderRepository.insert(order);
		return order;
	}

	public Order createOrder(UUID customerId, List<OrderItem> orderItems, UUID voucherId) {
		var voucher = voucherService.getVoucher(voucherId);
		var order = new Order(UUID.randomUUID(), customerId, orderItems, voucher);
		orderRepository.insert(order);
		voucherService.useVoucher(voucher);
		return order;
	}

}
