package com.prill.SchoolManagementSystem.jpa.service;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.prill.SchoolManagementSystem.jpa.dao.StudentDAO;
import com.prill.SchoolManagementSystem.jpa.entitymodels.Course;
import com.prill.SchoolManagementSystem.jpa.entitymodels.Student;
import com.prill.SchoolManagementSystem.jpa.util.HibernateUtil;


/**
 * The Student Service class defines the logic of the methods found in the Service DAO.
 * 
 * @author Jonathan Prill
 *
 */
public class StudentService extends HibernateUtil implements StudentDAO {
//	static Session session = HibernateUtil.getConnection();
//	static Transaction tx = session.beginTransaction();
	@Override
	public List<Student> getAllStudents() {
		Session session = HibernateUtil.getConnection();
		String hql = "FROM Student";
		TypedQuery<Student> query = session.createQuery(hql, Student.class);
		List<Student> studentResults = query.getResultList();
		for (Student s : studentResults) {
			System.out.println("Student Email= " + s.getsEmail() + ", Student Name= " + s.getsName()
					+ ", Student Password= " + s.getsPass());
		}
		return studentResults;
	}

	@Override
	public Student getStudentByEmail(String sEmail) {
		Session session = HibernateUtil.getConnection();
		String hql = "FROM Student s WHERE s.sEmail = :sEmail";
		TypedQuery query = session.createQuery(hql);
		query.setParameter("sEmail", sEmail);
		Student result = (Student) query.getSingleResult();
		System.out.println("Student Email= " + result.getsEmail() + ", Student Name= " + result.getsName()
				+ ", Student Password= " + result.getsPass());
		return result;
	}

	@Override
	public boolean validateStudent(String sEmail, String sPass) {
		Session session = HibernateUtil.getConnection();
		String hql = "FROM Student s WHERE s.sEmail = :sEmail";
		
		try {
			TypedQuery<Student> query = session.createQuery(hql, Student.class);
			query.setParameter("sEmail", sEmail);
			Student result = query.getSingleResult();
			if (result.getsEmail().equals(sEmail) && result.getsPass().equals(sPass)) {
				return true;
			} else {
				return false;
			}
			
		} catch (Exception e) {
			System.out.println("That Student Email DOES NOT Exist!!!");
		}

		return false;
	}

	@Override
	public void registerStudentToCourse(String sEmail, Course course) {
		Session session = HibernateUtil.getConnection();
		Transaction tx = session.beginTransaction();
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		List<Course> newCourseList = new ArrayList<>();
		Student s1 = new Student();
		s1 = getStudentByEmail(sEmail);
		s1.getsCourses().add(course);
//		System.out.println(s1.getsCourses());
		newCourseList = s1.getsCourses();
		System.out.println(newCourseList);
		s1.setsCourses(newCourseList);
		session.merge(s1);
//		factory.getCurrentSession().merge(s1);
		tx.commit();
		factory.close();
		session.close();
		
		
		
		
		
		
		
		
		
		
		
//		List<Course> sCourses = new ArrayList<Course>();
//		String hql = "SELECT * FROM Course c INNER JOIN student_course sc ON sc.sCourses_cId=c.cId INNER JOIN Student s ON sc.Student_semail=s.sEmail WHERE s.sEmail = ?";
//
//		try {
//			Connection connection = HibernateUtil.setConnection();
//			PreparedStatement stmt = connection.prepareStatement(hql);
//			stmt.setString(1, sEmail);
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				int courseId = rs.getInt("cId");
//				String courseName = rs.getString("cName");
//				String instName = rs.getString("cInstructorName");
//
//				Course c = new Course();
//				c.setcId(courseId);
//				c.setcName(courseName);
//				c.setcInstructorName(instName);
//
//				sCourses.add(c);
//			}
//			System.out.println(sCourses.toString());
//			sCourses.add(course);
//			System.out.println("=============");
//			System.out.println(sCourses.toString());
//			String SelectSQL = "UPDATE Student SET sCourses= :sCourses WHERE sEmail= :sEmail";
//
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

	}

	@Override
	public List<Course> getStudentCourses(String sEmail) {
		List<Course> sCourses = new ArrayList<Course>();
		String hql = "SELECT * FROM Course c INNER JOIN student_course sc ON sc.sCourses_cId=c.cId INNER JOIN Student s ON sc.Student_semail=s.sEmail WHERE s.sEmail = ?";
		try {
			Connection connection = HibernateUtil.setConnection();
			PreparedStatement stmt = connection.prepareStatement(hql);
			stmt.setString(1, sEmail);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int courseId = rs.getInt("cId");
				String courseName = rs.getString("cName");
				String instName = rs.getString("cInstructorName");

				Course c = new Course();
				c.setcId(courseId);
				c.setcName(courseName);
				c.setcInstructorName(instName);

				sCourses.add(c);
			}
			for (Course sc : sCourses) {
				System.out.println(sc.getcId() + "\t\t" + sc.getcName() + "\t\t" + sc.getcInstructorName());
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sCourses;
	}

}
