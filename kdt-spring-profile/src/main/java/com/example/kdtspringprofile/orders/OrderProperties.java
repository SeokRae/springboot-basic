package com.example.kdtspringprofile.orders;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.text.MessageFormat;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "kdt")
public class OrderProperties implements InitializingBean {

	private String version;

	private int minimumOrderAmount;

	private List<String> supportVendors;

	private String description;

//	@Value("${JAVA_HOME}")
//	private String javaHome;

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(MessageFormat.format("[OrderProperties] version -> {0}", version));
		System.out.println(MessageFormat.format("[OrderProperties] minimumOrderAmount -> {0}", minimumOrderAmount));
		System.out.println(MessageFormat.format("[OrderProperties] supportVendors -> {0}", supportVendors));
//		System.out.println(MessageFormat.format("[OrderProperties] javaHome -> {0}", javaHome));
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getMinimumOrderAmount() {
		return minimumOrderAmount;
	}

	public void setMinimumOrderAmount(int minimumOrderAmount) {
		this.minimumOrderAmount = minimumOrderAmount;
	}

	public List<String> getSupportVendors() {
		return supportVendors;
	}

	public void setSupportVendors(List<String> supportVendors) {
		this.supportVendors = supportVendors;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
//
//	public void setJavaHome(String javaHome) {
//		this.javaHome = javaHome;
//	}
//

//	public String getJavaHome() {
//		return javaHome;
//	}

}
