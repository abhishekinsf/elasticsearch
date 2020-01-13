package com.esearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author abhishek.k
 */
@SpringBootApplication
@ComponentScan(basePackages="com.esearch")
public class ElasticSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElasticSearchApplication.class, args);
	}

}
