package com.example.microservicie.app.users.services;

import org.springframework.stereotype.Service;

import com.example.microservices.commons.services.CommonServiceImpl;
import com.example.microservices.commons.users.models.entity.User;
import com.example.microservicie.app.users.models.repository.IUserRepository;

@Service
public class UserServiceImpl extends CommonServiceImpl<User, IUserRepository> implements IUserService {

	
}
