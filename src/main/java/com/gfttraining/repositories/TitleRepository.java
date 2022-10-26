package com.gfttraining.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gfttraining.models.Title;

public interface TitleRepository extends JpaRepository<Title, Integer> {
	
	  @Query("SELECT t FROM Title t WHERE t.name = :name")
	  public Title findTitleByName(String name);

	  @Query("SELECT t FROM Title t WHERE t.release_year = :releaseYear")
	  public List<Title> findTitleByReleaseYear(String releaseYear);


	  @Query("SELECT t FROM Title t WHERE t.description LIKE %:description%")
	  public List<Title> findTitleByDescription(String description);
	  
	  
	  
	  /*@Query("SELECT t FROM Title t INNER JOIN title_director td ON t.id = td.title_id WHERE td.director_id = :id")
	  public List<Title> findTitleByDirector(Integer id); */
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  /* ---------------------- searching titles by actor ---------------------- 

	  @Query(value = "SELECT * FROM title INNER JOIN title_actor on title.id = title_actor.title_id   WHERE title_actor.actor_id = :id ", nativeQuery = true)
	  public List<Title> findTitleByActor(Integer id);

	  /* ---------------------- searching titles by category ---------------------- 

	  @Query(value = "SELECT * FROM title INNER JOIN title_category on title.id = title_category.title_id WHERE title_category.category_id = :id", nativeQuery = true)
	  public List<Title> findTitleByCategory(Integer id);

	  /* --------------------------- RECOMMEND ENDPOINTS -------------------------- 

	  @Query(value = "SELECT * FROM title ORDER BY user_rating DESC LIMIT :limit", nativeQuery = true)
	  public List<Title> recommedBestTitles(Integer limit);

	  @Query(value = "SELECT * FROM title INNER JOIN title_category on title.id = title_category.title_id WHERE title_category.category_id = :id order by user_rating desc  LIMIT :limit", nativeQuery = true)
	  public List<Title> recommendBestTitlesByCategory(Integer id, Integer limit);*/
}

