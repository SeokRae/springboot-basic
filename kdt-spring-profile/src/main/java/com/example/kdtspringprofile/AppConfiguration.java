package com.example.kdtspringprofile;

import com.example.kdtspringprofile.config.YamlPropertiesFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(
		basePackages = {
				"com.example.kdtspringprofile.vouchers"
				, "com.example.kdtspringprofile.orders"
				, "com.example.kdtspringprofile.config"}
)
@PropertySource(value = "/application.yml", factory = YamlPropertiesFactory.class)
@EnableConfigurationProperties
public class AppConfiguration {
}