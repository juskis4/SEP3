package com.rest.consumingrest;

import Services.UserService;
import Sockets.Models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ConsumingRestApplication {

	private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);

	public static void main(String[] args) throws IOException {
		//Test RESTful services
		SpringApplication.run(ConsumingRestApplication.class, args);

		//Test Socket connection
		UserService userService = new UserService();
		User user = userService.ValidateLogin("Ionut","12345");
		System.out.println("Username got: " + user.getUsername() + ", " +
				"password got: " + user.getPassword());
	}
}