package com.example.microservices.app.sensors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.example.microservices.commons.sensors.models.entity"
			})
public class MicroserviceSensorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceSensorsApplication.class, args);
		System.out.println("Microservice \"Sensors\" launched and ready to work....");
	}

}
