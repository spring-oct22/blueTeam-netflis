package com.gfttraining.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gfttraining.models.Actor;

@Repository
@Transactional
public interface ActorRepository extends JpaRepository  <Actor, Integer>{
	@Query("select a from Actor a where a.name = :name") //?1
	List<Actor> getActorsByName(String name);

}
