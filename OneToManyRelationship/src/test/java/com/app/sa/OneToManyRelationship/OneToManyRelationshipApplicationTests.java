package com.app.sa.OneToManyRelationship;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Issue
 *        <p>
 *        <b>Title:</b>Tests should be broken into separate classes.<br/>
 *        <b>Description:</b>Currently all the tests are written in the single
 *        class file which is not good design for a bigger project. Find a way
 *        (preferably the ones practiced in real projects) how to break tests
 *        into separate classes.<br/>
 *        <b>Replication:</b>Scenario-Driven<br/>
 *        <b>Observations:</b>Scenario-Driven<br/>
 *        </p>
 * @author Harsh
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OneToManyRelationshipApplication.class)
public class OneToManyRelationshipApplicationTests implements CommandLineRunner {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Test
	public void contextLoads() {
	}

	// Student Record Testing //

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	}

}
