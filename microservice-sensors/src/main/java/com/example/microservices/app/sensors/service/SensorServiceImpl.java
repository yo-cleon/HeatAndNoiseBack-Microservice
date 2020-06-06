package com.example.microservices.app.sensors.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.microservices.app.sensors.models.repository.ISensorRepository;
import com.example.microservices.commons.sensors.models.entity.Sensor;
import com.example.microservices.commons.services.CommonServiceImpl;

@Service
public class SensorServiceImpl extends CommonServiceImpl<Sensor, ISensorRepository> implements ISensorService  {

//	@Override
//	public List<Sensor> findProjectId(Long id) {
//		return repository.findByProjectId(id);
//	}

}
