package com.example.busanzipback;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
	"spring.datasource.url=jdbc:h2:mem:my_db;MODE=MySQL",
	"spring.datasource.driver-class-name=org.h2.Driver"
})
class BusanzipBackApplicationTests {

	@Test
	void contextLoads() {
	}

}
