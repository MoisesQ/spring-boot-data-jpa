package com.projects.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.projects.springboot.app.models.entities.Client;

public interface IClientDao extends CrudRepository<Client, Long> {
	
}
