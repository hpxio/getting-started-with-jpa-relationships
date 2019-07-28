/**
 * 
 */
package com.app.sa.OneToManyRelationship.feedback;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author iHSPA
 *
 */
@Entity
@Table(name = "feedback")
public class FeedbackEntity {

	@Id
	private int id;

	@NotNull
	private int rating;

	private String review;

	/**
	 * 
	 */
	public FeedbackEntity() {
	}

	/**
	 * @param id
	 * @param rating
	 * @param review
	 */
	public FeedbackEntity(int id, @NotNull int rating, String review) {
		this.id = id;
		this.rating = rating;
		this.review = review;
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
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 * @return the review
	 */
	public String getReview() {
		return review;
	}

	/**
	 * @param review the review to set
	 */
	public void setReview(String review) {
		this.review = review;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\nFeedbackEntity [id=" + id + ", rating=" + rating + ", review=" + review + "]";
	}

}
