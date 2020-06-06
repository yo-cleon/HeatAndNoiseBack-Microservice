package com.example.microservices.app.sensors.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.microservices.app.sensors.models.repository.ISensorRepository;
import com.example.microservices.commons.sensors.models.entity.Sensor;
import com.example.microservices.commons.services.CommonServiceImpl;

@Service
public class SensorServiceImpl extends CommonServiceImpl<Sensor, ISensorRepository> implements ISensorService  {

	@Override
	@Transactional(readOnly = true)
	public List<Sensor> findBySensorPosition(String term) {
		return repository.findByPosition(term);
	}



}
