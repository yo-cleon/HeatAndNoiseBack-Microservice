package com.example.microservices.app.measures.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.microservices.app.measures.models.repository.IMeasureRepository;
import com.example.microservices.commons.sensors.models.entity.Measure;
import com.example.microservices.commons.services.CommonServiceImpl;

@Service
public class MeasureServiceImpl extends CommonServiceImpl<Measure, IMeasureRepository> implements IMeasureService{

	@Override
	public List<Measure> findBySensorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
