package com.banquito.cobros.receivables;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.banquito.cobros.receivables.repository")
@EntityScan(basePackages = "com.banquito.cobros.receivables.model")
@ComponentScan(basePackages = {
		"com.banquito.cobros.receivables.controller",
		"com.banquito.cobros.receivables.service",
		"com.banquito.cobros.receivables.util.mapper"
})
public class ReceivablesApplication {
	public static void main(String[] args) {
		SpringApplication.run(ReceivablesApplication.class, args);
	}
}
