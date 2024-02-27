package com.sk.codeengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CodeengineApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeengineApplication.class, args);
	}

}
