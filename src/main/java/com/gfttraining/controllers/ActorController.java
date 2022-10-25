package com.gfttraining.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gfttraining.models.Actor;
import com.gfttraining.services.ActorService;

@RestController
public class ActorController {
	@Autowired 
	private ActorService actorService;
	
	@GetMapping ("api/actors")	
	public List<Actor> allActors (){		
		
		return actorService.findAllActors();
	}
	
	@GetMapping ("/api/actors/{id}")
	public Actor getActorrById(@PathVariable Integer id) {
		
		Actor actor= actorService.findOneActor(id);			
			
		return actor;				
		
	}		
		
	@PostMapping ("/api/actors")
	public Actor postActor(@RequestBody Actor Actor ) {
			
		return actorService.newActor(Actor);
	}
	
	@PutMapping("/api/Actor/{id}")
	public Actor putActor(@RequestBody Actor Actor, @PathVariable Integer id) {	
		
		return actorService.changeActor(Actor,id);		
		
	}
	
	@DeleteMapping ("/api/Actor/{id}")
	public void deleteActor(@PathVariable Integer id) {
		actorService.deleteMyActor(id);
		
	}
}
