/**
 * 
 */
package com.app.sa.OneToManyRelationship.course;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.app.sa.OneToManyRelationship.feedback.FeedbackEntity;

/**
 * @author iHSPA
 *
 */
@Entity
@Table(name = "course")
@NamedQuery(name = "getAllCourse", query = "select course_rec0 from CourseEntity course_rec0")
public class CourseEntity {

	@Id
	int id;

	@NotNull
	String name;

	@OneToMany
	private List<FeedbackEntity> feedback = new ArrayList<FeedbackEntity>();

	/**
	 * @param id
	 * @param name
	 * @param feedback
	 */
	public CourseEntity(int id, @NotNull String name, List<FeedbackEntity> feedback) {
		super();
		this.id = id;
		this.name = name;
		this.feedback = feedback;
	}

	/**
	 * @param id
	 * @param name
	 */
	public CourseEntity(int id, @NotNull String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 * 
	 */
	public CourseEntity() {

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
	 * @return the feedback
	 */
	public List<FeedbackEntity> getFeedback() {
		return feedback;
	}

	/**
	 * @param feedback the feedback to set
	 */
	public void setFeedback(FeedbackEntity feedback) {
		this.feedback.add(feedback);
	}

	/**
	 * 
	 * @param feedback the feedback to remove
	 */
	public void removeFeedback(FeedbackEntity feedback) {
		this.feedback.remove(feedback);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\nCourseEntity [id=" + id + ", name=" + name + ", feedback=" + feedback + "]";
	}

}
