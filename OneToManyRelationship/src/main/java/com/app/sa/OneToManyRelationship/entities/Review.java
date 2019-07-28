/*******************************************************************************
 * NAME: ReviewEntity.java
 * FQN: OneToManyRelationship.com.app.sa.OneToManyRelationship.entities.ReviewEntity.java
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

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author iHSPA
 *
 */
@Entity
@Table(name = "review")
public class Review {

	@Id
	private int id;

	@NotNull
	private float rating;

	private String comment;

	@ManyToOne
	private Course course;

	public Review() {

	}

	/**
	 * @param id
	 * @param rating
	 * @param comment
	 */
	public Review(int id, @NotNull float rating, String comment,
			Course course) {
		this.id = id;
		this.rating = rating;
		this.comment = comment;
		this.course = course;
	}

	@Override
	public String toString() {
		return "ReviewEntity [id=" + id + ", rating=" + rating + ", comment="
				+ comment + ", course=" + course + "]";
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
	 * @return the rating
	 */
	public float getRating() {
		return rating;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	public void setRating(float rating) {
		this.rating = rating;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}

	/**
	 * @param course
	 *            the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

}
