/**
 * 
 */
package com.app.sa.OneToManyRelationship.student;

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
public class StudentRepository {

	@PersistenceContext
	EntityManager em;

	public void getStudentById(int id) {

	}

	/**
	 * 
	 * @param bean
	 */
	public StudentEntity createStudentRecord(StudentEntity bean) {
		em.persist(bean);
		return bean;
	}

	/**
	 * OBJECTIVE-2::Get all the records from the Student table.
	 * 
	 * @return List of all the Students Record
	 */
	public List<StudentEntity> getallStudents() {
		TypedQuery<StudentEntity> queryRes = em.createNamedQuery("getAllStudent", StudentEntity.class);
		return queryRes.getResultList();
	}

}
