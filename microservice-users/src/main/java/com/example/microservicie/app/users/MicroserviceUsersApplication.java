package com.example.microservicie.app.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.example.microservices.commons.users.models.entity"
			 
})
public class MicroserviceUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceUsersApplication.class, args);
		System.out.println("Microservice \"Users\" launched and ready to work....");
	}

}
