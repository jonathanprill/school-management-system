package com.prill.SchoolManagementSystem.jpa.entitymodels;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This Class creates the course table with id as the primary key; course name,
 * and instructor names as columns. This class is also linked to the Students
 * table with many to many relationship.
 * 
 * @author Jonathan Prill
 *
 */
@Entity
@Table
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cId;

	private String cName;
	private String cInstructorName;

	public Course() {
		this.cName = "";
		this.cInstructorName = "";
	}

	public Course(String cName, String cInstructorName) {
		super();
		this.cName = cName;
		this.cInstructorName = cInstructorName;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcInstructorName() {
		return cInstructorName;
	}

	public void setcInstructorName(String cInstructorName) {
		this.cInstructorName = cInstructorName;
	}

	@Override
	public String toString() {
		return "Course [cId=" + cId + ", cName=" + cName + ", cInstructorName=" + cInstructorName + "]";
	}



}
