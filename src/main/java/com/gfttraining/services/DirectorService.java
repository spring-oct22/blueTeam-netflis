package com.gfttraining.services;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.gfttraining.models.Director;
import com.gfttraining.repositories.DirectorRepository;


@Service
public class DirectorService {

	@Autowired
	private DirectorRepository directorRepository;
	
	
	//Find All 	
	public List<Director> findAllDirectors() {			
		return directorRepository.findAll();
	
		}
	
	//Pageable
	public Page<Director> findAllPageableDirectors (Pageable pageable){
		return directorRepository.findAll(pageable);
	}
	

	//Find by ID
	public Director findOneDirector(Integer id) {		
		return directorRepository.findById(id).get();
	}
	
	
	
	//Create - POST
	public	Director newDirector (Director director) {
		return directorRepository.save(director);
	}
	
	//Modify - PUT
	public Director changeDirector(Director director, Integer id) {
		
		Director changedDirector = directorRepository.findById(id).get();		
		
		changedDirector.setId(director.getId());
		changedDirector.setName(director.getName());
		
		return directorRepository.save(changedDirector);		
		
	}		
		
	//Delete - DELETE
		
	public  Director deleteMyDirector(Integer id) {
		Director director = directorRepository.findById(id).get();
		directorRepository.deleteById(id);
		return director;
	}
	
	//Endpoints director
	public List<Director> getDirectorsName(String name) {
	
		List<Director> director = directorRepository.getDirectorsByName(name);
		return director;
	}

		
	
}