/**
 * 
 */
package com.app.sa.OneToManyRelationship.Profile;

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
public class ProfileRepository {

	@PersistenceContext
	EntityManager em;

	/**
	 * OBJECTIVE-1::Get all profile record from the Profile table.
	 * 
	 * @return List of Profile Records
	 */
	public List<ProfileEntity> getAllProfile() {
		TypedQuery<ProfileEntity> queryRes = em.createNamedQuery("getAllProfile", ProfileEntity.class);
		return queryRes.getResultList();
	}

	public void getProfileById(int id) {

	}

}
