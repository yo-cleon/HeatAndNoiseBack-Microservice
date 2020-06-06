package com.example.microservicie.app.users.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.commons.controller.CommonController;
import com.example.microservices.commons.users.models.entity.User;
import com.example.microservicie.app.users.services.IUserService;

@RestController
public class UserController extends CommonController<User, IUserService>{
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editUser(@RequestBody User user, @PathVariable Long id) {
		
		Optional<User> o = service.findById(id);
		
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			User userEdited = o.get();
			userEdited.setFirstName(user.getFirstName());
			userEdited.setLastName(user.getLastName());
			userEdited.setEmail(user.getEmail());
			return ResponseEntity.status(HttpStatus.CREATED).body(service.save(userEdited));
		}
	}                                                                                                                       

}
