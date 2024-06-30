package com.example.complexeSportif;


import com.example.complexeSportif.role.Role;
import com.example.complexeSportif.role.RoleRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ComplexeSportifApplication {

	public static void main(String[] args) {SpringApplication.run(ComplexeSportifApplication.class, args);}

	@Bean
	public CommandLineRunner runner(RoleRepo roleRepo)
	{
		return args -> {
			if (roleRepo.findByName("USER").isEmpty()){
				roleRepo.save(
						Role.builder().name("USER").build()
				);
			}
		};

	}

}
