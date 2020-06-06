package com.example.microservices.app.projects.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.microservices.app.projects.models.entity.Project;

public interface IProjectRepository extends CrudRepository<Project, Long> {
	
	@Query("select p from Project p where p.projectName like %?1%")
	public List<Project> findByProjectName(String term);

}
