/**
 * 
 */
package com.app.sa.OneToManyRelationship.course;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

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
	 * @param course
	 * @return
	 */
	public CourseEntity createCourseRecord(CourseEntity course) {
		em.persist(course);
		return course;
	}

	/**
	 * 
	 * @return
	 */
	public List<CourseEntity> getAllCourses() {
		TypedQuery<CourseEntity> queryRes = em.createNamedQuery("getAllCourse", CourseEntity.class);
		return queryRes.getResultList();
	}
}
