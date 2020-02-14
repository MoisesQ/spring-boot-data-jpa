package com.projects.springboot.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.projects.springboot.app.models.entities.Client;
import com.projects.springboot.app.models.service.IClientService;

@Controller
public class ClientController {

	@Autowired
//	@Qualifier("ClientDaoJPA")
	private IClientService clientService;

	@GetMapping(value = "/list")
	public String list(Model model) {

		model.addAttribute("title", "Client List");
		model.addAttribute("clients", clientService.findAll());
		return "list";
	}

	@GetMapping(value = "/form")
	public String create(Model model) {

		Client client = new Client();
		model.addAttribute("client", client);
		model.addAttribute("title", "Client Form");
		return "form";
	}

	@GetMapping(value = "/form/{id}")
	public String edit(@PathVariable(value = "id") Long id, Model model) {

		Client client = null;

		if (id > 0) {
			client = clientService.findOne(id);
		} else {
			return "redirect:/list";
		}

		model.addAttribute("client", client);
		model.addAttribute("title", "Edit client");
		return "form";

	}

	@PostMapping(value = "/form")
	public String save(@Valid Client client, BindingResult result, Model model) {

		model.addAttribute("title", "Client Form");

		if (result.hasErrors()) {
			return "form";
		}

		clientService.save(client);
		return "redirect:/list";
	}

	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id) {

		if (id > 0) {
			clientService.delete(id);
		}

		return "redirect:/list";
	}

}
