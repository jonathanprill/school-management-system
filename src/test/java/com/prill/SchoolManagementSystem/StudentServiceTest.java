package com.prill.SchoolManagementSystem;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.prill.SchoolManagementSystem.jpa.entitymodels.Student;
import com.prill.SchoolManagementSystem.jpa.service.StudentService;

public class StudentServiceTest {

	private static StudentService studentService;

	/**
	 * This test simply tests the get Student By Email method. It compares a new Student object with what's already in the database.
	 */
	@Test
	public void testGetStudentByEmail() {
		studentService = new StudentService();
		Student expectedStudent = new Student();
		expectedStudent.setsEmail("hluckham0@google.ru");
		expectedStudent.setsName("Hazel Luckham");
		expectedStudent.setsPass("X1uZcoIh0dj");
		expectedStudent.setsCourses(null);

		Student actual = studentService.getStudentByEmail("hluckham0@google.ru");
		System.out.println(actual.getsEmail());
		assertEquals(expectedStudent.getsEmail(), actual.getsEmail());
	}

}
