package com.app.sa.OneToManyRelationship;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.sa.OneToManyRelationship.Profile.ProfileRepository;
import com.app.sa.OneToManyRelationship.course.CourseRepository;
import com.app.sa.OneToManyRelationship.student.StudentRepository;

/**
 * 
 * @author iHSPA
 *
 */
@SpringBootApplication
public class OneToManyRelationshipApplication implements CommandLineRunner {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(OneToManyRelationshipApplication.class, args);

	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		log.info("\nOneToManyRelationship - Project Started");
		log.info("\nAll Students -> {}", studentRepository.getallStudents());
		log.info("\nAll Profiles -> {}", profileRepository.getAllProfile());
		log.info("\nAll Courses -> {}", courseRepository.getAllCourses());
	}

}
