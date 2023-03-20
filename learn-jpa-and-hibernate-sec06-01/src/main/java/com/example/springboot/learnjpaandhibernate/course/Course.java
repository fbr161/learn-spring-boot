package com.example.springboot.learnjpaandhibernate.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="course")
public class Course {
	
	@Id
	private Long id;
	
	@Column(name="name")
	private String name;
	
	private String author;
	
	public Course() { }
		
	public Course(Long id, String name, String aurhor) {
		super();
		this.id = id;
		this.name = name;
		this.author = aurhor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String aurhor) {
		this.author = aurhor;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", aurhor=" + author + "]";
	}

}
