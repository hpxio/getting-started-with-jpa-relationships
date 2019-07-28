/**
 * 
 */
package com.app.sa.OneToManyRelationship.Profile;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Harsh
 *
 */
@Entity
@Table(name = "profile")
@NamedQuery(name = "getAllProfile", query = "select prof_rec0 from ProfileEntity prof_rec0")
public class ProfileEntity {

	@Id
	private int id;

	@NotNull
	private int status;

	@NotNull
	private float cgpa;

	private String stream;

	/**
	 * 
	 */
	public ProfileEntity() {
		// Default Constructor //
	}

	/**
	 * @param id
	 * @param status
	 * @param cgpa
	 * @param stream
	 */
	public ProfileEntity(int id, int status, float cgpa, String stream) {
		this.id = id;
		this.status = status;
		this.cgpa = cgpa;
		this.stream = stream;
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
	 * @return the cgpa
	 */
	public float getCgpa() {
		return cgpa;
	}

	/**
	 * @param cgpa the cgpa to set
	 */
	public void setCgpa(float cgpa) {
		this.cgpa = cgpa;
	}

	/**
	 * @return the stream
	 */
	public String getStream() {
		return stream;
	}

	/**
	 * @param stream the stream to set
	 */
	public void setStream(String stream) {
		this.stream = stream;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\nProfileEntity [id=" + id + ", status=" + status + ", cgpa=" + cgpa + ", stream=" + stream + "]";
	}

}
