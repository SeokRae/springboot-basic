package org.prgrms.kdt.domain.order;

import org.prgrms.kdt.domain.voucher.Voucher;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class Order {
	private final UUID orderId;
	private final UUID customerId;
	private final List<OrderItem> orderItems;
	private final Optional<Voucher> voucher;
	private OrderStatus orderStatus = OrderStatus.ACCEPTED;

	public Order(UUID orderId, UUID customerId, List<OrderItem> orderItems) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderItems = orderItems;
		this.voucher = Optional.empty();
	}

	public Order(UUID orderId, UUID customerId, List<OrderItem> orderItems, Voucher voucher) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderItems = orderItems;
		this.voucher = Optional.of(voucher);
	}

	public long totalAmount() {
		long beforeDiscount = orderItems.stream()
				.map(v -> v.getProductPrice() * v.getQuantity())
				.reduce(0L, Long::sum);
		return voucher
				.map(value -> value.discount(beforeDiscount))
				.orElse(beforeDiscount);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
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
		return Objects.equals(orderId, order.orderId) && Objects.equals(customerId, order.customerId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderId, customerId);
	}
}
