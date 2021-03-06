package com.example.microservices.app.sensors.service;

import java.util.List;

import com.example.microservices.commons.sensors.models.entity.Sensor;
import com.example.microservices.commons.services.ICommonService;

public interface ISensorService extends ICommonService<Sensor> {
	
	public List<Sensor> findBySensorPosition(String term);

}
