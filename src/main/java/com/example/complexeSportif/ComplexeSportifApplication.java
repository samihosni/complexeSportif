package com.example.complexeSportif;

import com.example.complexeSportif.entities.auth.RegisterRequest;
import com.example.complexeSportif.entities.auth.Role;
import com.example.complexeSportif.services.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import static com.example.complexeSportif.entities.auth.Role.ADMIN;
@SpringBootApplication
@EnableAsync
public class ComplexeSportifApplication {

	public static void main(String[] args) {SpringApplication.run(ComplexeSportifApplication.class, args);}
	@Bean
	public CommandLineRunner commandLineRunner(AuthenticationService authenticationService)
	{
		return args -> {
			var admin= RegisterRequest.builder()
					.firstname("Admin")
					.lastname("ADMIN")
					.email("admin@mail.com")
					.password("ca1920")
					.role(ADMIN)
					.build();
		};

	}

}
