package com.online.multitenantlib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MultitenantlibApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultitenantlibApplication.class, args);
	}

}
