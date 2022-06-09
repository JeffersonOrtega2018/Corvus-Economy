package com.finanzas;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.finanzas.Service.UserService;
import com.finanzas.entities.Role;
import com.finanzas.entities.User;

@SpringBootApplication
public class TfApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TfApiApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	
	@Bean
	CommandLineRunner run (UserService userService){
		return args ->{
			userService.saveRol(new Role(null,"ROLE_USER"));
			userService.saveRol(new Role(null,"ROLE_MANAGER"));
			userService.saveRol(new Role(null,"ROLE_ADMIN"));
			userService.saveRol(new Role(null,"ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null,"rodrigo@gmail.com","123","Rodrigo","Lopez",new ArrayList<>()));
			userService.saveUser(new User(null,"rodrigo1@gmail.com","123","Rodrigo1","Lopez1",new ArrayList<>()));
			userService.saveUser(new User(null,"rodrigo2@gmail.com","123","Rodrigo2","Lopez2",new ArrayList<>()));
			userService.saveUser(new User(null,"rodrigo3@gmail.com","123","Rodrigo3","Lopez3",new ArrayList<>()));

			userService.addRolToUser("rodrigo@gmail.com", "ROLE_SUPER_ADMIN");
			userService.addRolToUser("rodrigo1@gmail.com", "ROLE_ADMIN");
			userService.addRolToUser("rodrigo2@gmail.com", "ROLE_MANAGER");
			userService.addRolToUser("rodrigo3@gmail.com", "ROLE_USER");
		};
	}
}
