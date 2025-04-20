package com.feeprocess.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@OpenAPIDefinition(info = @Info(title = "Student Service API", version = "1.0", description = "APIs for Student Management"))
public class StudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}
	

	/*
	 * @Bean public RestTemplate restTemplate() { return new RestTemplate(); }
	 */

}
