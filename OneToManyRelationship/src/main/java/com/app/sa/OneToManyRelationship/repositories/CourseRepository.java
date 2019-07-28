/*******************************************************************************
 * NAME: CourseRepository.java
 * FQN: OneToManyRelationship.com.app.sa.OneToManyRelationship.repositories.CourseRepository.java
 * DATE: 14-Apr-2019
 * AUTHOR: iHSPA
 * DESCRIPTION: Short description of what this Class does.
 * CHANGELOG:
 * 
 * Copyright @ 2019, Harsh Poddar (RC) 
 ******************************************************************************/

/**
 * 
 */
package com.app.sa.OneToManyRelationship.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.app.sa.OneToManyRelationship.entities.Course;
import com.app.sa.OneToManyRelationship.entities.Review;

/**
 * @author iHSPA
 *
 */
@Repository
@Transactional
public class CourseRepository {

	@PersistenceContext
	EntityManager em;

	/**
	 * 
	 * @return
	 */
	public List<Course> getAllCourse() {
		TypedQuery<Course> res = em.createNamedQuery("getAllCourse",
				Course.class);
		return res.getResultList();
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Course getCourseById(int id) {
		return em.find(Course.class, id);
	}

	/**
	 * 
	 * @param courseId
	 * @return
	 */
	public List<Review> getCourseReview(int courseId) {
		Course course = this.getCourseById(courseId);
		return course.getReview();
	}

}