package com.example.busanzipback.common.healthcheck;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HealthCheckController {

	@GetMapping(value = "/health")
	public ResponseEntity<String> verifyServerAlice(){
		return ResponseEntity.ok().body("I'm alive!");
	}
}
