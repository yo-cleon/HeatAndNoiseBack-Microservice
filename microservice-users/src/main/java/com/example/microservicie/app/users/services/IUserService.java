package com.example.microservicie.app.users.services;

import com.example.microservices.commons.services.ICommonService;
import com.example.microservices.commons.users.models.entity.User;

public interface IUserService extends ICommonService<User> {
	
	public User findByEmail(String email);
}
