package com.example.kdtspringorder3.domain.order;

public enum OrderStatus {
	ACCEPTED,
	PAYMENT_REQUIRED,
	PAYMENT_CONFIRMED,
	PAYMENT_REJECTED,
	READY_FOR_DELIVERY,
	SHIPPED,
	SETTLED,
	CANCELLED
}
