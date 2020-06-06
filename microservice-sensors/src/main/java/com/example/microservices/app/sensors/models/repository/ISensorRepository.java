package com.example.microservices.app.sensors.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.microservices.commons.sensors.models.entity.Sensor;

public interface ISensorRepository extends CrudRepository<Sensor, Long> {
	

}
