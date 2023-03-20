package com.example.springboot.learnjpaandhibernate.course.jpa;

import org.springframework.stereotype.Repository;

import com.example.springboot.learnjpaandhibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void insert(Course course) {
		entityManager.merge(course);
	}
	
	public void deleteById(Long id) {
		Course course = findById(id);
		entityManager.remove(course);
	}
	
	public Course findById(Long id) {
		return entityManager.find(Course.class, id);
	}
	
}
