package com.example.kdtspringlogging;

import com.example.kdtspringlogging.config.YamlPropertiesFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(
		basePackages = {"com.example.kdtspringlogging.voucher", "com.example.kdtspringlogging.order", "com.example.kdtspringlogging.config"}
)
@PropertySource(value = "application.yaml", factory = YamlPropertiesFactory.class)
@EnableConfigurationProperties
public class AppConfiguration {
}