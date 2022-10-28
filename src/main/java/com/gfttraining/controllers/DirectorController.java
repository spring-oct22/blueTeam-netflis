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
import org.springframework.web.bind.annotation.RestController;

import com.gfttraining.exceptions.NotFoundException;
import com.gfttraining.models.Director;
import com.gfttraining.repositories.DirectorRepository;
import com.gfttraining.services.DirectorService;

@RestController
public class DirectorController {
	
	@Autowired
	private DirectorRepository directorRepository;
	
	@Autowired
	private DirectorService directorService;
	
	@GetMapping ("api/directors")	
	public ResponseEntity<List<Director>> allDirectors (){		
	
		return new ResponseEntity<>(directorService.findAllDirectors(), HttpStatus.OK);            
        
	}
	
	@GetMapping ("api/directors/pages")	
	public Page<Director> allPageableDirectors(@PageableDefault(size = 10, page = 0) Pageable pageable){
		
		return directorService.findAllPageableDirectors(pageable);
	}
	
	@GetMapping ("/api/directors/{id}")
	public  ResponseEntity<Director>  getDirectorById(@PathVariable Integer id) {
			
		try {
						
			Director director = directorService.findOneDirector(id);
			
			return new ResponseEntity<>(director, HttpStatus.OK);
	                
	            
		}catch (Exception e) {
			
			throw new NotFoundException ("Not Found"); 
		}
	}		
		
	@PostMapping ("/api/directors")
	public ResponseEntity<Director> postDirector(@RequestBody Director director ) {
			
		return new ResponseEntity<>(directorService.newDirector(director), HttpStatus.CREATED);
	}
	
	@PutMapping("/api/directors/{id}")
	public Director putDirector(@RequestBody Director director, @PathVariable Integer id) {	
		
		return directorService.changeDirector(director,id);		
		
	}
	
	@DeleteMapping ("/api/directors/{id}")
	public void deleteDirector(@PathVariable Integer id) {
		directorService.deleteMyDirector(id);
		
	}
}


