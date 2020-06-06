package com.example.microservices.app.sensors.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.microservices.commons.sensors.models.entity.Sensor;

public interface ISensorRepository extends CrudRepository<Sensor, Long> {
	
	@Query("select s from Sensor s where s.position like %?1%")
	public List<Sensor> findByPosition(String term);

}
