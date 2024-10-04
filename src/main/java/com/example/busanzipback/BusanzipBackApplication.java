package com.example.busanzipback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.busanzipback.domain.residency.util.RepositoryMapper;

@SpringBootApplication
public class BusanzipBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusanzipBackApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
