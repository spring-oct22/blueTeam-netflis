package com.gfttraining.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gfttraining.models.Category;
import com.gfttraining.repositories.CategoryRepository;


@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	
	//Find All 	
		public List<Category> findAllCategorys() {			
			return categoryRepository.findAll();
			}

		//Find by ID
		public Category findOneCategory(Integer id) {		
			return categoryRepository.findById(id).get();
		}
		
		//Create - POST
		public Category newCategory (Category Category) {
			return categoryRepository.save(Category);
		}
		
		//Modify - PUT
		public Category changeCategory(Category Category, Integer id) {
			
			Category changedCategory = categoryRepository.findById(id).get();		
			
			changedCategory.setId(Category.getId());
			changedCategory.setName(Category.getName());
			
			return categoryRepository.save(changedCategory);		
			
		}		
			
		//Delete - DELETE
			
		public Category deleteMyCategory(Integer id) {
			Category category = categoryRepository.findById(id).get();
			categoryRepository.deleteById(id);
			return category;
		}

		
	
}