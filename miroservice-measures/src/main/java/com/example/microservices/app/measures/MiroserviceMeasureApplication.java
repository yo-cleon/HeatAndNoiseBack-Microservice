package com.example.microservices.app.measures;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.example.microservices.commons.sensors.models.entity"
			})			
public class MiroserviceMeasureApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiroserviceMeasureApplication.class, args);
		System.out.println("Microservice \"Measures\" launched and ready to work....");
	}

}
