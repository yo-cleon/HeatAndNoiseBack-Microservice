package com.example.microservices.commons.services;

import java.util.Optional;



public interface ICommonService<E> {

	public Iterable<E> findAll();
	
	public Optional<E> findById(Long Id);
	
	public E save(E entity);
	
	public void deleteById(Long Id);
}
