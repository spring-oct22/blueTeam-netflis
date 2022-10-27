package com.gfttraining.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	ResponseEntity<List<Actor>> allActors (){
		return new ResponseEntity<>(actorService.findAllActors(), HttpStatus.OK);
	}
	
	@GetMapping ("api/actors/pages")	
	public ResponseEntity<Page<Actor>> allPageableActors(@PageableDefault(size = 10, page = 0) Pageable pageable){
		try {
			return new ResponseEntity<>(actorService.findAllPageableActors(pageable), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(actorService.findAllPageableActors(pageable), HttpStatus.NOT_FOUND);
		}
	}
	

	@GetMapping ("/api/actors/{id}")
	ResponseEntity<Actor> getActorrById(@PathVariable Integer id) {
		Actor actor= actorService.findOneActor(id);
		try {
			return new ResponseEntity<>(actor, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(actor, HttpStatus.NOT_FOUND);
		}
	    
	} 
		
	@PostMapping ("/api/actors")
	public ResponseEntity<Actor> postActor(@RequestBody Actor Actor ) {
		try {
			return new ResponseEntity<>(actorService.newActor(Actor), HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(actorService.newActor(Actor), HttpStatus.NOT_FOUND);
		}
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
