package com.example.microservices.app.measures.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.app.measures.service.IMeasureService;
import com.example.microservices.commons.controller.CommonController;
import com.example.microservices.commons.sensors.models.entity.Measure;


@RestController
public class MeasureController extends CommonController<Measure, IMeasureService>{
	
	@GetMapping("/by-sensor/{id}")
	public ResponseEntity<?> findBySensorId(@PathVariable Long id){
		return ResponseEntity.ok(service.findBySensorId(id));
	}

}
