/**
 * 
 */
package com.app.sa.OneToManyRelationship.student;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.app.sa.OneToManyRelationship.Profile.ProfileEntity;

/**
 * @author Harsh
 *
 */
@Entity
@Table(name = "student")
@NamedQuery(name = "getAllStudent", query = "select s_rec0 from StudentEntity s_rec0")
public class StudentEntity {

	@Id
	private int id;

	@NotNull
	private int status;

	@NotNull
	private String name;

	@OneToOne
	private ProfileEntity profile;

	/**
	 * 
	 */
	public StudentEntity() {
		// Default constructor //
	}

	/**
	 * @param id
	 * @param status
	 * @param name
	 * @param profile
	 * @param feedback
	 */
	public StudentEntity(int id, @NotNull int status, @NotNull String name, ProfileEntity profile) {
		this.id = id;
		this.status = status;
		this.name = name;
		this.profile = profile;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the profile
	 */
	public ProfileEntity getProfile() {
		return profile;
	}

	/**
	 * @param profile the profile to set
	 */
	public void setProfile(ProfileEntity profile) {
		this.profile = profile;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\nStudentEntity [id=" + id + ", status=" + status + ", name=" + name + ", profile=" + profile + "]";
	}

}
