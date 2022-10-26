package com.gfttraining.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.gfttraining.models.Category;
import com.gfttraining.services.CategoryService;

@RestController
public class CategoryController {
	@Autowired 
	private CategoryService categoryService;
	
	@GetMapping ("api/categorys")	
	public List<Category> allCategorys (){		
		
		return categoryService.findAllCategorys();
	}
	
	@GetMapping ("api/categories/pages")	
	public Page<Category> allPageableCategories(@PageableDefault(size = 10, page = 0) Pageable pageable){
		
		return categoryService.findAllPageableCategories(pageable);
	}
	
	@GetMapping ("/api/categorys/{id}")
	public Category getCategoryrById(@PathVariable Integer id) {
		
		Category Category= categoryService.findOneCategory(id);			
			
		return Category;				
		
	}		
		
	@PostMapping ("/api/categorys")
	public Category postCategory(@RequestBody Category Category ) {
			
		return categoryService.newCategory(Category);
	}
	
	@PutMapping("/api/categorys/{id}")
	public Category putCategory(@RequestBody Category Category, @PathVariable Integer id) {	
		
		return categoryService.changeCategory(Category,id);		
		
	}
	
	@DeleteMapping ("/api/categorys/{id}")
	public void deleteCategory(@PathVariable Integer id) {
		categoryService.deleteMyCategory(id);
		
	}
}
