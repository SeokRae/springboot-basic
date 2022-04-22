package com.example.kdtspringtest;

import com.example.kdtspringtest.config.YamlPropertiesFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(
		basePackages = {"com.example.kdtspringtest.voucher", "com.example.kdtspringtest.order", "com.example.kdtspringtest.config"}
)
@PropertySource(value = "application.yaml", factory = YamlPropertiesFactory.class)
@EnableConfigurationProperties
public class AppConfiguration {
}