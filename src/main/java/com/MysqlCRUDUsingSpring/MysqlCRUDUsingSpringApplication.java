package com.MysqlCRUDUsingSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.example.MysqlCRUDUsingSpring")
@SpringBootApplication
public class MysqlCRUDUsingSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysqlCRUDUsingSpringApplication.class, args);
	}
}
