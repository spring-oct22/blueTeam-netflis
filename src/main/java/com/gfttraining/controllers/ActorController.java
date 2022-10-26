package com.gfttraining.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping ("api/actors/pages")	
	public Page<Actor> allPageableActors(@PageableDefault(size = 10, page = 0) Pageable pageable){
		
		return actorService.findAllPageableActors(pageable);
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
	
	@PutMapping("/api/actors/{id}")
	public Actor putActor(@RequestBody Actor Actor, @PathVariable Integer id) {	
		
		return actorService.changeActor(Actor,id);		
		
	}
	
	@DeleteMapping ("/api/actors/{id}")
	public void deleteActor(@PathVariable Integer id) {
		actorService.deleteMyActor(id);
		
	}
	
	
	//Endpoints
	
	@GetMapping ("/api/endpoint/actor")
	public List<Actor> actorByName(@RequestParam(name = "name") String name) {
		return actorService.getActorsName(name);
	}
}
