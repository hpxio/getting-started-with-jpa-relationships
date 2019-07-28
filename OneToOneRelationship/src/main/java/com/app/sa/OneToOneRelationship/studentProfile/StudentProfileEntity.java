/**
 * 
 */

package com.app.sa.OneToOneRelationship.studentProfile;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 * @author iHSPA
 */
@Entity
@Table ( name = "profile" )
public class StudentProfileEntity {

    @Id
    private int id;

    private String graduation;

    @NotNull
    private String stream;

    @NotNull
    @Column ( columnDefinition = "Decimal(10,2) default '0.00'" )
    // Or - @Column(precision=10, scale=2) //
    private float cgpa;

    /**
     * 
     */
    public StudentProfileEntity ( ) {
    }

    /**
     * @param id
     * @param graduation
     * @param stream
     * @param cgpa
     */
    public StudentProfileEntity ( int id, String graduation, @NotNull String stream, @NotNull float cgpa ) {
        this.id = id;
        this.graduation = graduation;
        this.stream = stream;
        this.cgpa = cgpa;
    }

    /**
     * @return the id
     */
    public int getId ( ) {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId ( int id ) {
        this.id = id;
    }

    /**
     * @return the graduation
     */
    public String getGraduation ( ) {
        return graduation;
    }

    /**
     * @param graduation
     *            the graduation to set
     */
    public void setGraduation ( String graduation ) {
        this.graduation = graduation;
    }

    /**
     * @return the stream
     */
    public String getStream ( ) {
        return stream;
    }

    /**
     * @param stream
     *            the stream to set
     */
    public void setStream ( String stream ) {
        this.stream = stream;
    }

    /**
     * @return the cgpa
     */
    public float getCgpa ( ) {
        return cgpa;
    }

    /**
     * @param cgpa
     *            the cgpa to set
     */
    public void setCgpa ( float cgpa ) {
        this.cgpa = cgpa;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ( ) {
        return "StudentProfileEntity [id=" + id + ", graduation=" + graduation + ", stream=" + stream + ", cgpa=" + cgpa
                + "]";
    }

}
