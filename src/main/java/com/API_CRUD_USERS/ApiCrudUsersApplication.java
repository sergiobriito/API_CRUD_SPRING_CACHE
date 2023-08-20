package com.API_CRUD_USERS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ApiCrudUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCrudUsersApplication.class, args);
	}

}
