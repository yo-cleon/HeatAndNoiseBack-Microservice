package com.example.microservicie.app.users.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.microservices.commons.users.models.entity.User;

public interface IUserRepository extends CrudRepository<User, Long> {
	
	public User findByEmail(String email);
	

}
