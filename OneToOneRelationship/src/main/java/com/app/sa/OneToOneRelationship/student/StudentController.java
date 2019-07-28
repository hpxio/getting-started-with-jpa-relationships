/**
 * 
 */

package com.app.sa.OneToOneRelationship.student;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author iHSPA
 */
@RestController
public class StudentController {

    /**
     * 
     * @param id
     * @param status
     * @param name
     * @param profile_id
     */
    @RequestMapping ( path = "/app/student/create", method = RequestMethod.POST )
    public void createStudentController ( @RequestParam int id, @RequestParam byte status, @RequestParam String name,
            @RequestParam int profile_id ) {

    }

    /**
     * 
     * @param id
     */
    @ResponseBody
    @RequestMapping ( path = "/app/get/id", method = RequestMethod.GET )
    public void getById ( @RequestParam int id ) {
        // DAO/Repository accessor goes here //
    }

}
