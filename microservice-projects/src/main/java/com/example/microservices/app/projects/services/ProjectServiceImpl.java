package com.example.microservices.app.projects.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.microservices.app.projects.models.entity.Project;
import com.example.microservices.app.projects.models.repository.IProjectRepository;
import com.example.microservices.commons.services.CommonServiceImpl;

@Service
public class ProjectServiceImpl extends CommonServiceImpl<Project, IProjectRepository> implements IProjectService {

	@Override
	@Transactional(readOnly = true)
	public List<Project> findByProjectName(String term) {
		return repository.findByProjectName(term);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Project> findByProjectLocation(String term) {
		return repository.findByProjectLocation(term);
	}


}
