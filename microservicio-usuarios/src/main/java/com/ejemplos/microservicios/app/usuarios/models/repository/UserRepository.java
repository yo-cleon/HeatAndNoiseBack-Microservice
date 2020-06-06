package com.ejemplos.microservicios.app.usuarios.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.ejemplos.microservicios.app.usuarios.models.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
