package com.gfttraining.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.gfttraining.models.Director;
import com.gfttraining.services.DirectorService;
import java.util.Objects;

@RestController
public class DirectorController {
	
	@Autowired
	private DirectorService directorService;
	
	@GetMapping ("api/directors")	
	public List<Director> allDirectors (){		
		
		return directorService.findAllDirectors();
	}
	
	@GetMapping ("/api/directors/{id}")
	public  Director getDirectorById(@PathVariable Integer id) {
		
		Director director = directorService.findOneDirector(id);
		return director;					
		
	}		
		
	@PostMapping ("/api/directors")
	public ResponseEntity<Director> postDirector(@RequestBody Director director ) {
			
		return new ResponseEntity<>(directorService.newDirector(director), HttpStatus.CREATED);
	}
	
	@PutMapping("/api/director/{id}")
	public Director putDirector(@RequestBody Director director, @PathVariable Integer id) {	
		
		return directorService.changeDirector(director,id);		
		
	}
	
	@DeleteMapping ("/api/director/{id}")
	public void deleteDirector(@PathVariable Integer id) {
		directorService.deleteMyDirector(id);
		
	}
}


