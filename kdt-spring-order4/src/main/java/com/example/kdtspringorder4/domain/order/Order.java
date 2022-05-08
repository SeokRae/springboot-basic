package com.example.kdtspringorder4.domain.order;

import com.example.kdtspringorder4.domain.voucher.DefaultAmountVoucher;
import com.example.kdtspringorder4.domain.voucher.Voucher;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Order {

	private final UUID orderId;
	private final UUID customerId;
	private final List<OrderItem> orderItems;
	private final Voucher voucher;
	private OrderStatus orderStatus = OrderStatus.ACCEPTED;

	public Order(UUID orderId, UUID customerId, List<OrderItem> orderItems) {
		this(orderId, customerId, orderItems, new DefaultAmountVoucher());
	}

	public Order(UUID orderId, UUID customerId, List<OrderItem> orderItems, Voucher voucher) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderItems = orderItems;
		this.voucher = voucher;
	}

	public long totalAmount() {
		long beforeDiscount = orderItems.stream()
				.map(v -> v.getProductPrice() * v.getQuantity())
				.reduce(0L, Long::sum);
		return voucher.discount(beforeDiscount);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public UUID getOrderId() {
		return orderId;
	}

	@Override
	public String toString() {
		return "Order{" + "orderId=" + orderId + ", customerId=" + customerId + ", orderItems=" + orderItems + ", voucher=" + voucher + ", orderStatus=" + orderStatus + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Order order = (Order) o;
		return Objects.equals(orderId, order.orderId)
				&& Objects.equals(customerId, order.customerId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderId, customerId);
	}
}
