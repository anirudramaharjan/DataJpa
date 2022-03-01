package com.zorba;

import javax.transaction.Transactional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


@SpringBootApplication
public class SpringDataJpaCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaCrudApplication.class, args);
	
	
	}

}
