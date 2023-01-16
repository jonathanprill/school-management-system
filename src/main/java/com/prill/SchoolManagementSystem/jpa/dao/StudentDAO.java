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
	
	/**
	 * This method gets all students and returns a List of type Student
	 * @return
	 */
	List<Student> getAllStudents();
	
	/**
	 * This method gets one Student by their email and returns type Student
	 * @param sEmail
	 * @return
	 */
	Student getStudentByEmail(String sEmail);
	
	/**
	 * This method returns a boolean based on the students email and password matching what's in the database
	 * @param sEmail
	 * @param sPass
	 * @return
	 */
	boolean validateStudent(String sEmail, String sPass);
	
	/**
	 * This method allows students to register to new courses
	 * @param sEmail
	 * @param course
	 */
	void registerStudentToCourse(String sEmail, Course course);
	 
	/**
	 * This method returns a list of type Course for a single student
	 * @param sEmail
	 * @return
	 */
	List<Course> getStudentCourses(String sEmail);

}
