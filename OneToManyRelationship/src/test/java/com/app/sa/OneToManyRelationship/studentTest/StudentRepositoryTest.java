/**
 * 
 */
package com.app.sa.OneToManyRelationship.studentTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.sa.OneToManyRelationship.OneToManyRelationshipApplication;
import com.app.sa.OneToManyRelationship.Profile.ProfileEntity;
import com.app.sa.OneToManyRelationship.student.StudentEntity;
import com.app.sa.OneToManyRelationship.student.StudentRepository;

/**
 * @author Harsh
 *
 */
@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OneToManyRelationshipApplication.class)
public class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;

	public void contextLoad() {
		// Load Application context //
	}

	/**
	 * 
	 */
	@Test
	@DirtiesContext
	public void createStudentRecordTest() {
		// Create a record //
		StudentEntity bean = studentRepository
				.createStudentRecord(new StudentEntity(5, 1, "Amelia", new ProfileEntity(1005, 1, 8.6F, "ECE")));

		// Assert tests //
		assertEquals("Amelia", bean.getName());
		assertEquals(1005, bean.getProfile().getId());
	}

	/**
	 * 
	 */
	@Test
	public void getAllStudentsTest() {
		List<StudentEntity> list = studentRepository.getallStudents();

		// First Member //
		StudentEntity bean = list.get(0);
		assertNotEquals(2, bean.getId());
		assertNotNull(bean.getProfile());

		// Second Member//
		bean = list.get(1);
		assertEquals("EEE", bean.getProfile().getStream());
	}

}
