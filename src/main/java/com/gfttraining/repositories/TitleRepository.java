package com.gfttraining.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gfttraining.models.Title;

public interface TitleRepository extends JpaRepository<Title, Integer> {

}
