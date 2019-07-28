
package com.app.sa.OneToOneRelationship;


import javax.validation.constraints.NotNull;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;


import com.app.sa.OneToOneRelationship.student.StudentEntity;
import com.app.sa.OneToOneRelationship.student.StudentRepository;
import com.app.sa.OneToOneRelationship.studentProfile.StudentProfileEntity;
import com.app.sa.OneToOneRelationship.studentProfile.StudentProfileRepository;


@SpringBootApplication
public class OneToOneRelationshipApplication implements CommandLineRunner {

    public static void main ( String[] args ) {
        SpringApplication.run ( OneToOneRelationshipApplication.class, args );
    }


    Logger log = LoggerFactory.getLogger ( this.getClass ( ) );

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentProfileRepository profileRepository;


    /**
     * NOTE: In real situation following <code>run()</code> method might not be needed to marked with Transactional.
     * Here it is done for the sake of running demonstrations back to back on the same table using
     * <code>PersistenceContext</code>. In the production code all the repository calls are already marked Transactional
     * and are maintained in Session.
     */
    @Override
    @Transactional
    public void run ( String... args ) throws Exception {

        // Demonstration of Eager & Lazy Fetch //
        this.demoEagerAndLazyFetch ( );

        // Basic Demonstration of Persistence Context & Transaction Manager //
        this.showPersistanceContextInAction ( );
    }

    /**
     * Eager Fetch is mechanism in which Hibernate
     * retrieves the owned table data along with the owner without having to
     * explicitly queried. If you look into the trace you'll observe a left outer
     * join clause in the select query. But it is not always beneficial to use a
     * Eager Fetch. Consider a scenario where you just want to fetch the owner table
     * data. There, an unnecessary select for owned table is also executed.
     * Get stored Student Data - For 1-to-1 relation it is always Eager Fetch by default
     */
    @Transactional
    public void demoEagerAndLazyFetch ( ) {
        // To view Lazy Fetching in action, mark the One-2-one relation annotation with FetchType.LAZY //

        // First Transaction - Create Owned Data - Profile Data //
        StudentProfileEntity profile = new StudentProfileEntity ( 12, "PG Diploma", "CSc.", 7.8F );
        profileRepository.createStudentProfileRecord ( profile );

        // Second Transaction - Create Owner Data - Student Data //
        studentRepository.createStudentRecord ( new StudentEntity ( 5, ( @NotNull byte ) ( 1 ), "Nathan", profile ) );

        // Display created records //
        log.info ( "EAGER-FETCH::Student Record at 1 :: {}", studentRepository.getStudentRecordById ( 5 ) );
        log.info ( "LAZY-FETCH::Student Record at 2 :: {}", studentRepository.getStudentRecordById ( 2 ) );

    }


    /**
     * <b>OBJECTIVE-2</b>::Chapter-3::Demonstrate PersistanceContext, Transaction and Session.
     * <br/>
     * <p>
     * <b>Persistence Context</b><br/>
     * It is the in-memory container which handles the changes done to the entities.
     * Managed by the Entity Manager and controlled by the Transactions. It ensures
     * all the changes are monitored, captured and then stored reliably to the DB.<br/>
     * <b>Transaction Manager</b><br/>
     * Transactional is Hibernate's equivalent of Sessions & Session Manager. It
     * defines set of rules such that if there are 10 changes for an entity marked
     * with transaction, then if 1 fails all others will be rolled-back too. Thus
     * ensuring the consistency of the operations on DB.
     * </p>
     */
    @Transactional
    private void showPersistanceContextInAction ( ) {

        // Get student records //
        StudentEntity student = studentRepository.getStudentRecordById ( 1 );
        log.info ( "Currently Viewing : Student : {}", student );

        // Get Profile from Student //
        StudentProfileEntity profile = student.getProfile ( );
        log.info ( "Currently Viewing : Profile : {}", profile );

        // Update Profile data //
        profile.setStream ( "Information Technology" );
        log.info ( "Currently Viewing : Profile++ : {}", profile );

        // Update student data //
        student.setName ( "Dave Lee" );
        log.info ( "Currently Viewing : Student++ : {}", student );
    }
}
