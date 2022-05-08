package com.example.kdtspringorder4.repository;


import com.example.kdtspringorder4.domain.order.Order;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Profile("dev")
@Repository
public class MemoryOrderRepository implements OrderRepository {
	private final Map<UUID, Order> storage = new ConcurrentHashMap<>();

	@Override
	public Order insert(Order order) {
		storage.put(order.getOrderId(), order);
		return order;
	}
}
