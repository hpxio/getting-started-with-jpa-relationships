/**
 * 
 */
package com.app.sa.OneToOneRelationship.studentProfile;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author iHSPA
 */
@Repository
@Transactional
public class StudentProfileRepository {

    @Autowired
    EntityManager em;

    /**
     * @param bean
     */
    public void createStudentProfileRecord ( StudentProfileEntity bean ) {
        em.merge ( bean );
    }

    /**
     * @param id
     * @return
     */
    public StudentProfileEntity getStudentProfileRecordById ( int id ) {
        return em.find ( StudentProfileEntity.class, id );
    }

}
