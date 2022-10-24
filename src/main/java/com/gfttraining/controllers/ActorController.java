package com.gfttraining.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.gfttraining.services.ActorService;

@RestController
public class ActorController {
	@Autowired 
	private ActorService actorService;
}
