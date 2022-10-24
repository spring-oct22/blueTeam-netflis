package com.gfttraining.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gfttraining.models.Actor;

public interface ActorRepository extends JpaRepository  <Actor, Integer>{

}
