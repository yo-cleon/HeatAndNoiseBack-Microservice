package com.example.microservices.app.projects.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.app.projects.models.entity.Project;
import com.example.microservices.app.projects.services.IProjectService;
import com.example.microservices.commons.controller.CommonController;
import com.example.microservices.commons.sensors.models.entity.Sensor;
import com.example.microservices.commons.users.models.entity.User;

@RestController
public class ProjectController extends CommonController<Project, IProjectService>{
	
	@PutMapping("/{projectId}")
	public ResponseEntity<?> editProject(@RequestBody Project project, @PathVariable Long projectId) {
		
		Optional<Project> p = service.findById(projectId);
		
		if(p.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			Project projectEdited = p.get();
			projectEdited.setProjectName(project.getProjectName());
			projectEdited.setDescription(project.getDescription());
			projectEdited.setLocation(project.getLocation());
			return ResponseEntity.status(HttpStatus.CREATED).body(service.save(projectEdited));
		}
	}
	
	@GetMapping("/filter/{term}")
	public ResponseEntity<?> filterProjects(@PathVariable String term){
		return ResponseEntity.ok(service.findByProjectName(term));
	}
	
	@PutMapping("/{id}/add-user")
	public ResponseEntity<?> assignProjectToUser(@RequestBody User user, @PathVariable Long id){
		Optional<Project> p = this.service.findById(id);
		
		if (p.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Project projectEdited = p.get();
		projectEdited.addUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(projectEdited));
	}
	
	@PutMapping("/{id}/remove-user")
	public ResponseEntity<?> deleteProjectFromUser(@RequestBody User user, @PathVariable Long id){
		Optional<Project> p = this.service.findById(id);
		
		if (p.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Project projectEdited = p.get();
		projectEdited.removeUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(projectEdited));
	}
	
	@PutMapping("/{id}/add-sensor")
	public ResponseEntity<?> assignProjectToUser(@RequestBody Sensor sensor, @PathVariable Long id){
		Optional<Project> p = this.service.findById(id);
		
		if (p.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Project projectEdited = p.get();
		projectEdited.addSensor(sensor);
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(projectEdited));
	}
	
	
	
}
