package com.ejemplos.microservicios.app.usuarios.services;

import org.springframework.stereotype.Service;

import com.ejemplos.microservicios.app.usuarios.models.entity.User;
import com.ejemplos.microservicios.app.usuarios.models.repository.UserRepository;
import com.ejemplos.microservicios.commons.services.CommonServiceImpl;

@Service
public class UserServiceImpl extends CommonServiceImpl<User, UserRepository> implements IUserService {

	


}
