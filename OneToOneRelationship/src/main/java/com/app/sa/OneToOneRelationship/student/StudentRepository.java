/**
 * 
 */
package com.app.sa.OneToOneRelationship.student;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author iHSPA
 */
@Repository
@Transactional
public class StudentRepository {

    @Autowired
    EntityManager em;

    /**
     * @param bean
     */
    public void createStudentRecord ( StudentEntity bean ) {
        em.merge ( bean );
    }

    /**
     * @param id
     * @return
     */
    public StudentEntity getStudentRecordById ( int id ) {
        return em.find ( StudentEntity.class, id );
    }

}
