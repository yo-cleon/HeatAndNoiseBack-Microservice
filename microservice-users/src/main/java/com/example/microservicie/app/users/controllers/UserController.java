package com.example.microservicie.app.users.controllers;

import java.io.IOException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.microservices.commons.controller.CommonController;
import com.example.microservices.commons.users.models.entity.User;
import com.example.microservicie.app.users.services.IUserService;

@RestController
public class UserController extends CommonController<User, IUserService>{
	
	@GetMapping("/find-by-email/{email}")
	public ResponseEntity<?> filterUsersByEmail(@PathVariable String email){
		return ResponseEntity.ok(service.findByEmail(email));
	}
	
	@GetMapping("/img/{id}")
	public ResponseEntity<?> getPhotoUser(@PathVariable Long id) {
		
		Optional<User> o = service.findById(id);
		
		if (o.isEmpty() || o.get().getPhoto() == null) {
			return ResponseEntity.notFound().build();
		}
		
		Resource img = new ByteArrayResource(o.get().getPhoto());
		
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(img);
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

	@PostMapping("/save-with-photo")
	public ResponseEntity<?> saveUserWithPhoto(@Valid User user, BindingResult result, 
			@RequestParam MultipartFile file ) throws IOException {
		if (!file.isEmpty()) {
			user.setPhoto(file.getBytes());
		}
		return super.saveEntity(user, result);
	}
	
	@PutMapping("/edit-with-photo/{id}")
	public ResponseEntity<?> editUserWithPhoto(@Valid User user, BindingResult result, @PathVariable Long id, 
			@RequestParam MultipartFile file) throws IOException {
		
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
			if (!file.isEmpty()) {
				userEdited.setPhoto(file.getBytes());
			}
			return ResponseEntity.status(HttpStatus.CREATED).body(service.save(userEdited));
		}
	}
	
	

}
