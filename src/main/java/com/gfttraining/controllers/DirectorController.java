package com.gfttraining.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.gfttraining.services.DirectorService;

@RestController
public class DirectorController {
	
	@Autowired
	private DirectorService directorService;

}
