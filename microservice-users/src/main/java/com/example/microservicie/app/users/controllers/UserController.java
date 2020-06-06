package com.example.microservicie.app.users.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.commons.controller.CommonController;
import com.example.microservices.commons.users.models.entity.User;
import com.example.microservicie.app.users.services.IUserService;

@RestController
public class UserController extends CommonController<User, IUserService>{
	
	@GetMapping("/find-by-email/{email}")
	public ResponseEntity<?> filterProjectsByEmail(@PathVariable String email){
		return ResponseEntity.ok(service.findByEmail(email));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editUser(@Valid @RequestBody User user, BindingResult result, @PathVariable Long id) {
		
		if (result.hasErrors()) {
			return this.validate(result);
		}
		
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
