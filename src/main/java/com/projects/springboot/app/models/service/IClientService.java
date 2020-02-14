package com.projects.springboot.app.models.service;

import java.util.List;

import com.projects.springboot.app.models.entities.Client;

public interface IClientService {

	public List<Client> findAll();

	public Client findOne(Long id);

	public void save(Client client);

	public void delete(Long id);
}
