package com.ejemplos.microservicios.app.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroservicioUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioUsuariosApplication.class, args);
		System.out.println("Microservice \"Users\" launched and ready to work....");
	}

}
