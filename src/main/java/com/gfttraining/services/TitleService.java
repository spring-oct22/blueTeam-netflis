package com.gfttraining.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	//Pageable
		public Page<Title> findAllPageableTitles (Pageable pageable){
			return titleRepository.findAll(pageable);
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
	
	//ENDPOINTS
	
	public List<Title> getTitleName(String name) {
		
		List<Title> title = titleRepository.findTitleByName(name);
		return title;
	}
	public List<Title> getTitleByReleaseYear(String releaseYear) {
		
		List<Title> title = titleRepository.findTitleByReleaseYear(releaseYear);
		return title;
	}
	public List<Title> getTitleByDescription(String description) {
			
		List<Title> title = titleRepository.findTitleByDescription(description);
		return title;
	}
	public List<Title> getTitleByDirector(Integer id) {
		
		List<Title> title = titleRepository.findTitleByDirector(id);
		return title;
	}
	public List<Title> getTitleByActor(Integer id) {
		
		List<Title> title = titleRepository.findTitleByActor(id);
		return title;
	}
	public List<Title> getTitleByCategory(Integer id) {
		
		List<Title> title = titleRepository.findTitleByCategory(id);
		return title;
	}
	
	
	//RECOMMENDS
	
	public List<Title> getrecommedBestTitles(Integer limit) {
		
		List<Title> title = titleRepository.recommedBestTitles().subList(0, limit);
		return title;
	}
	public List<Title> getrecommendBestTitlesByCategory(Integer id, Integer limit) {
		
		List<Title> title = titleRepository.recommendBestTitlesByCategory(id,limit);
		return title;
	}

}
