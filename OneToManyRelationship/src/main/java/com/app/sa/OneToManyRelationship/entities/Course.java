/*******************************************************************************
 * NAME: CourseEntity.java
 * FQN: OneToManyRelationship.com.app.sa.OneToManyRelationship.entities.CourseEntity.java
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
package com.app.sa.OneToManyRelationship.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author iHSPA
 *
 */
@Entity
@Table(name = "course")
@NamedQuery(name = "getAllCourse", query = "select c from Course c")
public class Course {

	@Id
	private int id;

	@NotNull
	private String name;

	@OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
	private List<Review> review = new ArrayList<Review>();

	/**
	 * 
	 */
	public Course() {
	}

	/**
	 * @param id
	 * @param name
	 */
	public Course(int id, @NotNull String name,
			ArrayList<Review> review) {
		super();
		this.id = id;
		this.name = name;
		this.review = review;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the review
	 */
	public List<Review> getReview() {
		return review;
	}

	/**
	 * @param review
	 *            the review to set
	 */
	public void setReview(Review review) {
		this.review.add(review);
	}

	@Override
	public String toString() {
		return "CourseEntity [id=" + id + ", name=" + name + "]";
	}

}
