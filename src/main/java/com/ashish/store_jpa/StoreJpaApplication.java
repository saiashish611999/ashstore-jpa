package com.ashish.store_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ashish.store_jpa.services.UsersService;

@SpringBootApplication
public class StoreJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(StoreJpaApplication.class, args);

		UsersService usersService = context.getBean(UsersService.class);

		// usersService.showEntityStates();
		usersService.showAddresses();

		context.close();
	}

}
