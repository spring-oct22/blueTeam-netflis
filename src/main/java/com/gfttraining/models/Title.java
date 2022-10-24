package com.gfttraining.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "title")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Title {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@NotNull
	private Integer id;
	@NotNull
	private String name;
	@NotNull
	private String date_added;
	@NotNull
	@Range(min=1900, max= 2022)
	private String release_year;
	@NotNull	
	private String rating;
	@NotNull
	private String duration;
	@NotNull
	private String description;
	@NotNull
	@Range(min=0, max=10)
	private Float user_rating;
	@NotNull
	@Min(0)
	private Integer num_ratings;
	@ManyToMany (mappedBy = "director")
    Set<Director> directors;
	@ManyToMany (mappedBy = "actor")
    Set<Actor> actor;
	@ManyToMany (mappedBy = "actor")
    Set<Category> category;
	
	public Title() {}

	
	
	public Title(@NotNull Integer id, @NotNull String name, @NotNull String date_added,
			@NotNull @Range(min = 1900, max = 2022) String release_year, @NotNull String rating,
			@NotNull String duration, @NotNull String description, @NotNull @Range(min = 0, max = 10) Float user_rating,
			@NotNull @Min(0) Integer num_ratings, Set<Director> directors, Set<Actor> actor, Set<Category> category) {
		super();
		this.id = id;
		this.name = name;
		this.date_added = date_added;
		this.release_year = release_year;
		this.rating = rating;
		this.duration = duration;
		this.description = description;
		this.user_rating = user_rating;
		this.num_ratings = num_ratings;
		this.directors = directors;
		this.actor = actor;
		this.category = category;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate_added() {
		return date_added;
	}

	public void setDate_added(String date_added) {
		this.date_added = date_added;
	}

	public String getRelease_year() {
		return release_year;
	}

	public void setRelease_year(String release_year) {
		this.release_year = release_year;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getUser_rating() {
		return user_rating;
	}

	public void setUser_rating(Float user_rating) {
		this.user_rating = user_rating;
	}

	public Integer getNum_ratings() {
		return num_ratings;
	}

	public void setNum_ratings(Integer num_ratings) {
		this.num_ratings = num_ratings;
	}

	public Set<Director> getDirectors() {
		return directors;
	}

	public void setDirectors(Set<Director> directors) {
		this.directors = directors;
	}

	public Set<Actor> getActor() {
		return actor;
	}

	public void setActor(Set<Actor> actor) {
		this.actor = actor;
	}

	public Set<Category> getCategory() {
		return category;
	}

	public void setCategory(Set<Category> category) {
		this.category = category;
	}



	@Override
	public String toString() {
		return "Title [id=" + id + ", name=" + name + ", date_added=" + date_added + ", release_year=" + release_year
				+ ", rating=" + rating + ", duration=" + duration + ", description=" + description + ", user_rating="
				+ user_rating + ", num_ratings=" + num_ratings + ", directors=" + directors + "]";
	}	
	
	
	
	
}	