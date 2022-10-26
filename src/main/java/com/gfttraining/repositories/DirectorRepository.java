package com.gfttraining.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gfttraining.models.Director;

@Repository
@Transactional
public interface DirectorRepository extends JpaRepository  <Director, Integer>{
	@Query("select d from Director d order by d.name")
	List<Director> getDirectorsByName();
}
