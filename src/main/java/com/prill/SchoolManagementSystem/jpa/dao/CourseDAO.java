package com.prill.SchoolManagementSystem.jpa.dao;

import java.util.List;

import com.prill.SchoolManagementSystem.jpa.entitymodels.Course;

/**
 * The Course DAO interface defines the methods that interact with the course table
 * 
 * @author Jonathan Prill
 *
 */
public interface CourseDAO {
	
	/**
	 * This method gets all courses and returns a list of type Course 
	 * @return
	 */
	List<Course> getAllCourses();
	
	/**
	 * This method gets one course by cId and return one type Course
	 * @param cId
	 * @return
	 */
	Course getCourseById(int cId);

}
