package com.example.kdtspringorder4;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Bean을 정의한 Context
 */
@Configuration
@ComponentScan(basePackages = {
		"com.example.kdtspringorder4.domain"
		, "com.example.kdtspringorder4.repository"
		, "com.example.kdtspringorder4.service"
})
public class AppConfiguration {

}
