package com.example.microservices.app.measures.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.microservices.commons.sensors.models.entity.Measure;

public interface IMeasureRepository extends PagingAndSortingRepository<Measure, Long>{
	
	@Query("select s.measures from Sensor s where s.id = ?1")
	public List<Measure> findBySensorId(Long id);

}
