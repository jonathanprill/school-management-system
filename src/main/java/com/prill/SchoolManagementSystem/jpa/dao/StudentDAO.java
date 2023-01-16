package com.prill.SchoolManagementSystem.jpa.dao;

import java.util.List;

import com.prill.SchoolManagementSystem.jpa.entitymodels.Course;
import com.prill.SchoolManagementSystem.jpa.entitymodels.Student;


/**
 * The Student DAO interface defines the methods that interact with the student table
 * 
 * @author Jonathan Prill
 *
 */
public interface StudentDAO {
	
	List<Student> getAllStudents();
	
	Student getStudentByEmail(String sEmail);
	
	boolean validateStudent(String sEmail, String sPass);
	
	void registerStudentToCourse(String sEmail, Course course);
	 
	List<Course> getStudentCourses(String sEmail);

}
