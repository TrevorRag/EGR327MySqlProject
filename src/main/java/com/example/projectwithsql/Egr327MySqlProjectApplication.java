package com.example.projectwithsql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Egr327MySqlProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Egr327MySqlProjectApplication.class, args);
	}
}
