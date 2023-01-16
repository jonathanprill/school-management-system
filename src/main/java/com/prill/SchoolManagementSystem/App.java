package com.prill.SchoolManagementSystem;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.prill.SchoolManagementSystem.jpa.dao.CourseDAO;
import com.prill.SchoolManagementSystem.jpa.entitymodels.Course;
import com.prill.SchoolManagementSystem.jpa.entitymodels.Student;
import com.prill.SchoolManagementSystem.jpa.service.CourseService;
import com.prill.SchoolManagementSystem.jpa.service.StudentService;
import com.prill.SchoolManagementSystem.jpa.util.HibernateUtil;

/**
 * This program follows the work flow of the SBA example. IT allows users to log into their accounts,
 * Once signed in, they are shown a list of their enlisted classes. The user is then prompted to register 
 * to a new class. They are then shown a full list of all classes available in the database.
 * Once they make a selection, that selection is added to their course list and they are automatically logged out.
 *
 */
public class App {
	static Session session = HibernateUtil.getConnection();
	static Transaction t = session.beginTransaction();

	public static void main(String[] args) {
		/**
		 * If you have trouble logging in, I made a user with an email of test@email.com and password of pass
		 * 
		 */
		SchoolMenu menu = new SchoolMenu();
		menu.runSchoolMenu();

		/**
		 * If for any reason you need to seed the database, uncomment this method:
		 */
//		seedDatabase();

	}

	
	/**
	 * This method seeds the database and returns nothing
	 */
	public static void seedDatabase() {

		Course course1 = new Course("English", "Anderea Scamaden");
		Course course2 = new Course("Mathematics", "Eustace Niemetz");
		Course course3 = new Course("Anatomy", "Reynolds Pastor");
		Course course4 = new Course("Organic Chemistry", "Odessa Belcher");
		Course course5 = new Course("Physics", "Dani Swallow");
		Course course6 = new Course("Digital Logic", "Glenden Reilingen");
		Course course7 = new Course("Object Oriented Programming", "Giselle Ardy");
		Course course8 = new Course("Data Structures", "Carolan Stoller");
		Course course9 = new Course("Politics", "Carmita De Maine");
		Course course10 = new Course("Art", "Kingsly Doxsey");

		session.save(course1);
		session.save(course2);
		session.save(course3);
		session.save(course4);
		session.save(course5);
		session.save(course6);
		session.save(course7);
		session.save(course8);
		session.save(course9);
		session.save(course10);

		List<Course> courseList1 = new ArrayList<Course>();
		courseList1.add(course1);
		courseList1.add(course2);

		List<Course> courseList2 = new ArrayList<Course>();
		courseList2.add(course3);
		courseList2.add(course4);

		List<Course> courseList3 = new ArrayList<Course>();
		courseList3.add(course5);
		courseList3.add(course6);

		List<Course> courseList4 = new ArrayList<Course>();
		courseList3.add(course7);
		courseList3.add(course8);

		List<Course> courseList5 = new ArrayList<Course>();
		courseList3.add(course9);
		courseList3.add(course10);

		Student student1 = new Student("hluckham0@google.ru", "Hazel Luckham", "X1uZcoIh0dj", courseList1);
		Student student2 = new Student("sbowden1@yellowbook.com", "Sonnnie Bowden", "SJc4aWSU", courseList2);
		Student student3 = new Student("qllorens2@howstuffworks.com", "Quillan Llorens", "W6rJuxd", courseList3);
		Student student4 = new Student("cstartin3@flickr.com", "Clem Startin", "XYHzJ1S", courseList4);
		Student student5 = new Student("tattwool4@biglobe.ne.jp", "Thornie Attwool", "Hjt0SoVmuBz", courseList5);
		Student student6 = new Student("hguerre5@deviantart.com", "Harcourt Guerre", "OzcxzD1PGs", courseList1);
		Student student7 = new Student("htaffley6@columbia.edu", "Holmes Taffley", "xowtOQ", courseList2);
		Student student8 = new Student("aiannitti7@is.gd", "Alexandra Iannitti", "TWP4hf5j", courseList3);
		Student student9 = new Student("ljiroudek8@sitemeter.com", "Laryssa Jiroudek", "bXRoLUP", courseList4);
		Student student10 = new Student("cjaulme9@bing.com", "Cahra Jaulme", "FnVklVgC6r6", courseList5);
		Student student11 = new Student("test@email.com", "Jonathan Prill", "pass", courseList1);

		session.save(student1);
		session.save(student2);
		session.save(student3);
		session.save(student4);
		session.save(student5);
		session.save(student6);
		session.save(student7);
		session.save(student8);
		session.save(student9);
		session.save(student10);
		session.save(student11);

		t.commit();
		session.close();
	}
}
