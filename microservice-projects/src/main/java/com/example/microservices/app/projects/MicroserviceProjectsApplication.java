package com.example.microservices.app.projects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.example.microservices.commons.users.models.entity",
			 "com.example.microservices.commons.sensors.models.entity",
			 "com.example.microservices.app.projects.models.entity"})
public class MicroserviceProjectsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProjectsApplication.class, args);
		System.out.println("Microservice \"Projects\" launched and ready to work....");
	}

}
