package com.gfttraining.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.gfttraining.models.Actor;
import com.gfttraining.repositories.ActorRepository;


@Service
public class ActorService {

	@Autowired
	private ActorRepository actorRepository;
	
	
	//Find All 	
	public List<Actor> findAllActors() {			
		return actorRepository.findAll();
		}
	
	//Pageable
		public Page<Actor> findAllPageableActors (Pageable pageable){
			return actorRepository.findAll(pageable);
		}
		

	//Find by ID
	public Actor findOneActor(Integer id) {		
		return actorRepository.findById(id).get();
	}
	
	//Create - POST
	public Actor newActor (Actor actor) {
		return actorRepository.save(actor);
	}
	
	//Modify - PUT
	public Actor changeActor(Actor actor, Integer id) {
		
		Actor changedactor = actorRepository.findById(id).get();		
		
		changedactor.setId(actor.getId());
		changedactor.setName(actor.getName());
		
		return actorRepository.save(changedactor);		
		
	}		
		
	//Delete - DELETE
		
	public Actor deleteMyActor(Integer id) {
		Actor actor = actorRepository.findById(id).get();
		actorRepository.deleteById(id);
		return actor;
	}
	
	
	//Endpoints actor
	public List<Actor> getActorsName(String name) {
	
		List<Actor> actor = actorRepository.getActorsByName(name);
		return actor;
	}

		
	
}