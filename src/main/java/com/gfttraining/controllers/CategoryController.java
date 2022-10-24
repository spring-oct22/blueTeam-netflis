package com.gfttraining.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.gfttraining.services.CategoryService;

@RestController
public class CategoryController {
	@Autowired 
	private CategoryService categoryService;
}
