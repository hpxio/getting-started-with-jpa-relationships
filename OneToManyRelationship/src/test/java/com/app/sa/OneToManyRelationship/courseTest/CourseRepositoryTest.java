/**
 * 
 */
package com.app.sa.OneToManyRelationship.courseTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.sa.OneToManyRelationship.OneToManyRelationshipApplication;
import com.app.sa.OneToManyRelationship.course.CourseEntity;
import com.app.sa.OneToManyRelationship.course.CourseRepository;

/**
 * @author iHSPA
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OneToManyRelationshipApplication.class)
public class CourseRepositoryTest {

	@Autowired
	CourseRepository courseRepository;

	/**
	 * 
	 */
	public void contextLoad() {
		// Implementation goes here //
	}

	/**
	 * 
	 */
	@Test
	@Transactional
	@DirtiesContext
	public void createCourseRecordTest() {
		// Create Test Record //
		CourseEntity course = courseRepository.createCourseRecord(new CourseEntity(5, "Spring Boot"));

		// Assert Tests //
		assertNotEquals(1, course.getId());
		assertEquals(5, course.getId());
		assertEquals("Spring Boot", course.getName());

		// Check that no Feedback is yet attached //
		assertNotNull(course.getFeedback());
	}

}
