package com.example.kdtspringtest;

import com.example.kdtspringtest.order.OrderProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(
		basePackages = {"com.example.kdtspringtest.voucher", "com.example.kdtspringtest.order"}
)
public class KdtSpringTestApplication {


	private static final Logger logger = LoggerFactory.getLogger(KdtSpringTestApplication.class);

	public static void main(String[] args) {
		var applicationContext = SpringApplication.run(KdtSpringTestApplication.class, args);
		var orderProperties = applicationContext.getBean(OrderProperties.class);
		logger.error("logger name => {}", logger.getName());
		logger.warn("version -> {}", orderProperties.getVersion());
		logger.warn("minimumOrderAmount -> {}", orderProperties.getMinimumOrderAmount());
		logger.warn("supportVendors -> {}", orderProperties.getSupportVendors());
		logger.warn("description -> {}", orderProperties.getDescription());

	}
}
