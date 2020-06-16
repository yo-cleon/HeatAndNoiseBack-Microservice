package com.example.microservicie.app.users.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.microservices.commons.users.models.entity.User;

public interface IUserRepository extends PagingAndSortingRepository<User, Long> {
	
	public User findByEmail(String email);
	

}
