/**
 * 
 */

package com.app.sa.OneToOneRelationship.student;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import com.app.sa.OneToOneRelationship.studentProfile.StudentProfileEntity;


/**
 * @author iHSPA
 */

@Entity
@Table ( name = "student" )
public class StudentEntity {

    @Id
    private int id;

    @NotNull
    private byte status;

    @NotNull
    private String name;

    // Chapter-1::One-To-One Relationship Mapping //
    // Chapter-2::Lazy Fetch & Eager Fetch //
    @OneToOne ( fetch = FetchType.LAZY )
    private StudentProfileEntity profile;

    /**
     * 
     */
    public StudentEntity ( ) {
    }

    /**
     * @param id
     * @param status
     * @param name
     */
    public StudentEntity ( int id, @NotNull byte status, @NotNull String name ) {
        this.id = id;
        this.status = status;
        this.name = name;
    }

    /**
     * @param id
     * @param status
     * @param name
     * @param profile
     */
    public StudentEntity ( int id, @NotNull byte status, @NotNull String name, StudentProfileEntity profile ) {
        this.id = id;
        this.status = status;
        this.name = name;
        this.profile = profile;
    }

    /**
     * @return the id
     */
    public int getId ( ) {
        return id;
    }

    /**
     * @return the name
     */
    public String getName ( ) {
        return name;
    }

    /**
     * @return the profile
     */
    public StudentProfileEntity getProfile ( ) {
        return profile;
    }

    /**
     * @return the status
     */
    public byte getStatus ( ) {
        return status;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId ( int id ) {
        this.id = id;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName ( String name ) {
        this.name = name;
    }

    /**
     * @param profile
     *            the profile to set
     */
    public void setProfile ( StudentProfileEntity profile ) {
        this.profile = profile;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus ( byte status ) {
        this.status = status;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ( ) {
        return "\nStudentEntity [id=" + id + ", status=" + status + ", name=" + name + ", profile=" + profile + "]";
    }

}
