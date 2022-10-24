package com.gfttraining.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gfttraining.models.Title;
import com.gfttraining.repositories.TitleRepository;

@Service
public class TitleService {
	
	@Autowired
	private TitleRepository titleRepository;
	
	
	//Find All 	
	public List<Title> findAllTitles() {			
		return titleRepository.findAll();
		}

	//Find by ID
	public Title findOneTitle(Integer id) {		
		return titleRepository.findById(id).get();
	}
	
	//Create - POST
	public	Title newTitle(Title title) {
		return titleRepository.save(title);
	}
	
	//Modify - PUT
	public Title changeTitle(Title title, Integer id) {
		
		Title changedTitle = titleRepository.findById(id).get();		
		
		changedTitle.setId(title.getId());
		changedTitle.setName(title.getName());
		changedTitle.setDate_added(title.getDate_added());
		changedTitle.setRelease_year(title.getRelease_year());
		changedTitle.setRating(title.getRating());
		changedTitle.setDuration(title.getDuration());
		changedTitle.setDescription(title.getDuration());
		changedTitle.setUser_rating(title.getUser_rating());
		changedTitle.setNum_ratings(title.getNum_ratings());		
		
		
		return titleRepository.save(changedTitle);		
		
	}		
		
	//Delete - DELETE
		
	public  Title deleteMyTitle(Integer id) {
		Title title = titleRepository.findById(id).get();
		titleRepository.deleteById(id);
		return title;
	}

}
