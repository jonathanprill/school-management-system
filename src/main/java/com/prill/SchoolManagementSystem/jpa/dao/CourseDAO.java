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
	
	List<Course> getAllCourses();
	
	Course getCourseById(int cId);

}
