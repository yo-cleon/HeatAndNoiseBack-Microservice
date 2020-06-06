package com.example.microservices.app.projects.services;

import java.util.List;

import com.example.microservices.app.projects.models.entity.Project;
import com.example.microservices.commons.services.ICommonService;

public interface IProjectService extends ICommonService<Project>{

	public List<Project> findByProjectName(String term);
	
}
