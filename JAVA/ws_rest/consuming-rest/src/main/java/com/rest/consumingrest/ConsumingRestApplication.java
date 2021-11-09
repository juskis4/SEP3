package com.rest.consumingrest;

import Controllers.UserController;
import Services.IUserService;
import Services.UserService;
import Sockets.Models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

@SpringBootApplication
@ComponentScan(basePackageClasses = UserController.class)
public class ConsumingRestApplication {

	private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);

	public static void main(String[] args)
			throws IOException, ClassNotFoundException
	{
		//Test RESTful services
		SpringApplication.run(ConsumingRestApplication.class, args);

		//Test Socket connection
		IUserService userService = new UserService();
		User user = userService.ValidateLogin("admin","admin");
		System.out.println("Username got: " + user.getUsername() + ", " +
				"password got: " + user.getPassword());
	}
}