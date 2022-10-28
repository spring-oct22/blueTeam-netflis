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
import com.gfttraining.models.Title;
import com.gfttraining.services.TitleService;

@RestController
public class TitleController {

	@Autowired
	private TitleService titleService;
	
	@GetMapping ("api/titles")	
	public ResponseEntity<List<Title>> allTitles (){		
		
		return new ResponseEntity<>(titleService.findAllTitles(), HttpStatus.OK); 
	}
	
	@GetMapping ("api/titles/pages")	
	public Page<Title> allPageableTitles(@PageableDefault(size = 10, page = 0) Pageable pageable){
		
		return titleService.findAllPageableTitles(pageable);
	}
	
	@GetMapping ("/api/titles/{id}")
	public Title getTitlerById(@PathVariable Integer id) {
		
		Title title= titleService.findOneTitle(id);			
			
		return title;				
		
	}		
		
	@PostMapping ("/api/titles")
	public ResponseEntity<Title> postTitle(@RequestBody Title title ) {
			
		return new ResponseEntity<>(titleService.newTitle(title), HttpStatus.CREATED);
	}
	
	@PutMapping("/api/titles/{id}")
	public Title putTitle(@RequestBody Title title, @PathVariable Integer id) {	
		
		return titleService.changeTitle(title,id);		
		
	}
	
	@DeleteMapping ("/api/titles/{id}")
	public void deleteTitle(@PathVariable Integer id) {
		titleService.deleteMyTitle(id);
		
	}
	
	//Endpoints
	
    @GetMapping("/api/titles/name")
    public List<Title> getByName(@RequestParam(value = "name") String name) {

        return titleService.getTitleName(name);
    }
    @GetMapping("/api/titles/releaseyear")
    public List<Title> getByYear(@RequestParam(value = "year") String year) {
        return titleService.getTitleByReleaseYear(year);
    }

    @GetMapping("/api/titles/description")
    public List<Title> getByDescription(@RequestParam(value = "description") String description) {
        return titleService.getTitleByDescription(description);
    }
    
    @GetMapping("/api/titles/{id}/director")
    public List<Title> getByDirector(@PathVariable Integer id) {
        return titleService.getTitleByDirector(id);
    }
    
    @GetMapping("/api/titles/{id}/actor")
    public List<Title> getByActor(@PathVariable Integer id) {
        return titleService.getTitleByActor(id);
    }

    @GetMapping("/api/titles/{id}/category")
    public List<Title> getByCategory(@PathVariable Integer id) {
        return titleService.getTitleByCategory(id);

    }
    
    //Recommend
    
    @GetMapping("/api/titles/best")
	public List<Title> gotrecommedBestTitles(@RequestParam(name = "limit", defaultValue = "10") Integer limit) {
		
		List<Title> title = titleService.getrecommedBestTitles(limit);
		return title;
	}
}

