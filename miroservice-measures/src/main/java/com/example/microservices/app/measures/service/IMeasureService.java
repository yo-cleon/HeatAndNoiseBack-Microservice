package com.example.microservices.app.measures.service;

import java.util.List;

import com.example.microservices.commons.sensors.models.entity.Measure;
import com.example.microservices.commons.services.ICommonService;

public interface IMeasureService extends ICommonService<Measure> {

	public List<Measure> findBySensorId(Long id);
}
