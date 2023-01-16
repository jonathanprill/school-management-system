package com.prill.SchoolManagementSystem.jpa.entitymodels;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * This Class creates the student table with email as the PK; and name, and
 * password as columns. This class is also linked to the Courses table with many
 * to many relationship.
 * 
 * @author Jonathan Prill
 *
 */

@Entity
@Table
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "semail", nullable = false, length=50)
	private String sEmail;

	private String sName;
	private String sPass;

	@ManyToMany(targetEntity = Course.class, cascade = CascadeType.ALL)
	private List<Course> sCourses;

	public Student() {
		this.sEmail = "";
		this.sName = "";
		this.sPass = "";
		this.sCourses = null;
	}

	public Student(String sEmail, String sName, String sPass, List<Course> sCourses) {
		super();
		this.sEmail = sEmail;
		this.sName = sName;
		this.sPass = sPass;
		this.sCourses = sCourses;
	}



	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsPass() {
		return sPass;
	}

	public void setsPass(String sPass) {
		this.sPass = sPass;
	}

	public List<Course> getsCourses() {
		return sCourses;
	}

	public void setsCourses(List<Course> sCourses) {
		this.sCourses = sCourses;
	}

	@Override
	public String toString() {
		return "Student [sEmail=" + sEmail + ", sName=" + sName + ", sPass=" + sPass + ", sCourses=" + sCourses + "]";
	}

	


}
