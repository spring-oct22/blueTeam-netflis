package com.gfttraining.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "director")
public class Director {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@NotNull
	private Integer id;
	@NotNull
	private String name;	
	@ManyToMany
	@JoinTable(name = "title_director", 
	joinColumns = @JoinColumn(name = "director_id"), 
	inverseJoinColumns = @JoinColumn(name = "title_id"))
    Set<Title> title;
	
	public Director() {}
	
	public Director(@NotNull Integer id, @NotNull String name, Set<Title> title) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
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

	public Set<Title> getTitles() {
		return title;
	}

	public void setTitles(Set<Title> title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Director [id=" + id + ", name=" + name + ", titles=" + title + "]";
	}	
	
	
	
}
