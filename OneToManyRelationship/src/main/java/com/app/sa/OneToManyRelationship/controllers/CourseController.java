/*******************************************************************************
 * NAME: CourseController.java
 * FQN: OneToManyRelationship.com.app.sa.OneToManyRelationship.controllers.CourseController.java
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
package com.app.sa.OneToManyRelationship.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.sa.OneToManyRelationship.entities.Course;
import com.app.sa.OneToManyRelationship.repositories.CourseRepository;

/**
 * @author iHSPA
 *
 */
@RestController
public class CourseController {

	@Autowired
	CourseRepository repository;

	@ResponseBody
	@RequestMapping(path = "/app/course/all", method = RequestMethod.GET)
	public List<Course> getAllCourse() {
		return repository.getAllCourse();
	}

	@ResponseBody
	@RequestMapping(path = "/app/course/id", method = RequestMethod.GET)
	public Course getCourseById(@RequestParam int id) {
		return repository.getCourseById(id);
	}

}
