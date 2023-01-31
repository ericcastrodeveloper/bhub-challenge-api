package com.example.bhubchallengeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BhubChallengeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BhubChallengeApiApplication.class, args);
	}

}
