package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

public class BookMngMapperTestConfig {
	
	private static final String url ="jdbc:mysql://localhost:3306/books?serverTimezone=JST";
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
	@Value("${spring.datasource.driver-class-name}")
	private String driver;
	@Bean
	public DataSource dataSource() {
	return new TransactionAwareDataSourceProxy(
	DataSourceBuilder
	.create()
	.username(this.username)
	.password(this.password)
	.url(url)
	.driverClassName(this.driver)
	.build());

	}
}
