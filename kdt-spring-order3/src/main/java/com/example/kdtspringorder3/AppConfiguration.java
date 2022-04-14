package com.example.kdtspringorder3;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Bean을 정의한 Context
 */
@Configuration
@ComponentScan(basePackages = {
		"com.example.kdtspringorder3.domain"
		, "com.example.kdtspringorder3.repository"
		, "com.example.kdtspringorder3.service"
})
public class AppConfiguration {

}
