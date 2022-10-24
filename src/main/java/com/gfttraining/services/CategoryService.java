package com.gfttraining.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gfttraining.models.Category;
import com.gfttraining.repositories.CategoryRepository;


@Service
public class CategoryService {

	@Autowired
	private CategoryRepository CategoryRepository;
	
	
	//Find All 	
	public List<Category> findAllCategorys() {			
		return CategoryRepository.findAll();
		}

	//Find by ID
	public Category findOneCategory(Integer id) {		
		return CategoryRepository.findById(id).get();
	}
	
	//Create - POST
	public Category newCategory (Category category) {
		return CategoryRepository.save(category);
	}
	
	//Modify - PUT
	public Category changeCategory(Category category, Integer id) {
		
		Category changedCategory = CategoryRepository.findById(id).get();		
		
		changedCategory.setId(category.getId());
		changedCategory.setName(category.getName());
		
		return CategoryRepository.save(changedCategory);		
		
	}		
		
	//Delete - DELETE
		
	public Category deleteMyCategory(Integer id) {
		Category category = CategoryRepository.findById(id).get();
		CategoryRepository.deleteById(id);
		return category;
	}

		
	
}