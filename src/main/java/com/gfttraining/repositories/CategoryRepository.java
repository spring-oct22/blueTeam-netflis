package com.gfttraining.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gfttraining.models.Category;

public interface CategoryRepository extends JpaRepository <Category, Integer>{

}
