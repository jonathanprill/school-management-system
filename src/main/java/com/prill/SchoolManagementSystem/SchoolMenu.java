package com.prill.SchoolManagementSystem;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.prill.SchoolManagementSystem.jpa.dao.CourseDAO;
import com.prill.SchoolManagementSystem.jpa.dao.StudentDAO;
import com.prill.SchoolManagementSystem.jpa.entitymodels.Course;
import com.prill.SchoolManagementSystem.jpa.service.CourseService;
import com.prill.SchoolManagementSystem.jpa.service.StudentService;
import com.prill.SchoolManagementSystem.jpa.util.HibernateUtil;


/**
 * The School Menu is what prompts the user to makes selections. 
 * It also defines the overall flow of the user experience.
 * 
 * @author Jonathan Prill
 *
 */
public class SchoolMenu {
	 static Session session = HibernateUtil.getConnection();
	static Transaction t = session.beginTransaction();
	private String sEmail;
	private String sPass;

	StudentDAO query = new StudentService();
	CourseDAO courseQuery = new CourseService();
	Scanner input = new Scanner(System.in);

	public void runSchoolMenu() {
		System.out.println("Welcome");
		int userSelection;
		int userSelection2;
		int courseSelection;
		while (true) {
			System.out.println("Are you a(n)");
			System.out.println("1. Student");
			System.out.println("2. Quit");
			System.out.println("Please Enter 1 or 2 ");
			userSelection = input.nextInt();

			switch (userSelection) {
			case 1:
				System.out.println("Enter your Email:");
				String userEmail = input.next();
				System.out.println("Enter your Password:");
				String userPassword = input.next();

				boolean validated = query.validateStudent(userEmail, userPassword);

				if (validated) {
					System.out.println("\nMy Classes:\n");
					System.out.println("Course ID \t Course Name \t Instructor Name");
					query.getStudentCourses(userEmail);
					System.out.println("\nMake a selection:");
					System.out.println("1. Register to a Class");
					System.out.println("2. Logout");
					System.out.println("Please Enter 1 or 2");
					userSelection2 = input.nextInt();
					switch (userSelection2) {
					case 1:
//						System.out.println("\nAll Courses:\n");
						courseQuery.getAllCourses();
						System.out.println("\nWhich course would you like to register for?");
						System.out.println("Enter a number: ");
						courseSelection = input.nextInt();						
						Course newlyAddedCourse = courseQuery.getCourseById(courseSelection);
						query.registerStudentToCourse(userEmail, newlyAddedCourse);
						t.commit();
						session.close();
						System.out.println("You're new course has been added.");
						System.out.println("Signing out...");
						System.exit(0);
					case 2:
						System.out.println("You have been signed out.");
						System.exit(0);
					}

				} else {
					System.out.println("Incorrect Credentials! \nExiting...");
					System.exit(0);
				}

			case 2:
				System.out.println("You have been signed out.");
				System.exit(0);
			}
		}

	}
}
