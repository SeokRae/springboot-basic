package com.example.kdtspringlogging;

import com.example.kdtspringlogging.order.OrderProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(
		basePackages = {"com.example.kdtspringlogging.voucher", "com.example.kdtspringlogging.order"}
)
public class KdtSpringLoggingApplication {
	private static final Logger logger = LoggerFactory.getLogger(KdtSpringLoggingApplication.class);

	public static void main(String[] args) {
		var applicationContext = SpringApplication.run(KdtSpringLoggingApplication.class, args);
		var orderProperties = applicationContext.getBean(OrderProperties.class);
		logger.error("logger name => {}", logger.getName());
		logger.warn("version -> {}", orderProperties.getVersion());
		logger.warn("minimumOrderAmount -> {}", orderProperties.getMinimumOrderAmount());
		logger.warn("supportVendors -> {}", orderProperties.getSupportVendors());
		logger.warn("description -> {}", orderProperties.getDescription());
	}

}
