package com.prill.SchoolManagementSystem.jpa.service;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.prill.SchoolManagementSystem.jpa.dao.CourseDAO;
import com.prill.SchoolManagementSystem.jpa.entitymodels.Course;
import com.prill.SchoolManagementSystem.jpa.util.HibernateUtil;

/**
 * The Course Service class defines the logic of the methods found in the Course DAO.
 * 
 * @author Jonathan Prill
 *
 */
public class CourseService extends HibernateUtil implements CourseDAO{

	@Override
	public List<Course> getAllCourses() {
		Session session = HibernateUtil.getConnection();
		String hql = "FROM Course";
		TypedQuery<Course> query = session.createQuery(hql, Course.class);
		List<Course> courseResults = query.getResultList();
		System.out.println("\nAll Courses:\n");
		System.out.println("Course ID \t Course Name \t Instructor Name");
		for(Course c : courseResults) {
			System.out.println(c.getcId() + "\t\t" + c.getcName() + "\t\t" + c.getcInstructorName());
		}
		return courseResults;
	}

	@Override
	public Course getCourseById(int cId) {
		Session session = HibernateUtil.getConnection();
		String hql = "FROM Course c WHERE c.cId = :cId";
		TypedQuery query = session.createQuery(hql);
		query.setParameter("cId", cId);
		Course result = (Course) query.getSingleResult();
		return result;
	}

}
