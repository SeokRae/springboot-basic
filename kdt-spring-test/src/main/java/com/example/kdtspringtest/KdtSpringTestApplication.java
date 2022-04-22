package com.example.kdtspringtest;

import com.example.kdtspringtest.order.OrderProperties;
import org.apache.logging.log4j.util.EnvironmentPropertySource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;

@SpringBootApplication
@ComponentScan(
		basePackages = {"com.example.kdtspringtest.voucher", "com.example.kdtspringtest.order"}
)
public class KdtSpringTestApplication {

	private static final Logger logger = LoggerFactory.getLogger(KdtSpringTestApplication.class);

	public static void main(String[] args) {
		var springApplication = new SpringApplication(KdtSpringTestApplication.class);
		springApplication.setAdditionalProfiles("local");

		var applicationContext = springApplication.run(args);
		var orderProperties = applicationContext.getBean(OrderProperties.class);
		logger.error("logger name => {}", logger.getName());
		logger.warn("version -> {}", orderProperties.getVersion());
		logger.warn("minimumOrderAmount -> {}", orderProperties.getMinimumOrderAmount());
		logger.warn("supportVendors -> {}", orderProperties.getSupportVendors());
		logger.warn("description -> {}", orderProperties.getDescription());

	}
}
