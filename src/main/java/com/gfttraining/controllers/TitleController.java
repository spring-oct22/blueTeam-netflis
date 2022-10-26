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
import com.gfttraining.models.Title;
import com.gfttraining.services.TitleService;

@RestController
public class TitleController {

	@Autowired
	private TitleService titleService;
	
	@GetMapping ("api/titles")	
	public List<Title> allTitles (){		
		
		return titleService.findAllTitles();
	}
	
	@GetMapping ("/api/titles/{id}")
	public Title getTitlerById(@PathVariable Integer id) {
		
		Title title= titleService.findOneTitle(id);			
			
		return title;				
		
	}		
		
	@PostMapping ("/api/titles")
	public Title postTitle(@RequestBody Title title ) {
			
		return titleService.newTitle(title);
	}
	
	@PutMapping("/api/titles/{id}")
	public Title putTitle(@RequestBody Title title, @PathVariable Integer id) {	
		
		return titleService.changeTitle(title,id);		
		
	}
	
	@DeleteMapping ("/api/titles/{id}")
	public void deleteTitle(@PathVariable Integer id) {
		titleService.deleteMyTitle(id);
		
	}
}

