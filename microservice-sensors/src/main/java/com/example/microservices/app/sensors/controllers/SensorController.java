package com.example.microservices.app.sensors.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.app.sensors.service.ISensorService;
import com.example.microservices.commons.controller.CommonController;
import com.example.microservices.commons.sensors.models.entity.Sensor;

@RestController
public class SensorController extends CommonController<Sensor, ISensorService>{
	
	@GetMapping("/filter-position/{term}")
	public ResponseEntity<?> getSensorByPosition(@PathVariable String term) {
		return ResponseEntity.ok(service.findBySensorPosition(term));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editSensor(@Valid @RequestBody Sensor sensor, BindingResult result, @PathVariable Long id) {
		
		if (result.hasErrors()) {
			return this.validate(result);
		}
		
		Optional<Sensor> s = service.findById(id);
		
		if(s.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			Sensor sensorEdited = s.get();
			sensorEdited.setMac(sensor.getMac());
			sensorEdited.setPosition(sensor.getPosition());
			sensorEdited.setStatus(sensor.isStatus());
			return ResponseEntity.status(HttpStatus.CREATED).body(service.save(sensorEdited));
		}
	}
	

	

}
