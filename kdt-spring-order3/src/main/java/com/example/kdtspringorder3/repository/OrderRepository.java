package com.example.kdtspringorder3.repository;

import com.example.kdtspringorder3.domain.order.Order;

public interface OrderRepository {
	Order insert(Order order);
}
