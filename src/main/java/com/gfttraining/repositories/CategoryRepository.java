package com.gfttraining.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gfttraining.models.Category;

public interface CategoryRepository extends JpaRepository <Category, Integer>{
	@Query("select c from Category c where c.name = :name") //?1
	List<Category> getCategorysByName(String name);
}
