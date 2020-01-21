/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myorg.springbootrestapijunit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.myorg.springbootrestapijunit5.model.Student;
import com.myorg.springbootrestapijunit5.services.StudentService;

/**
 *
 * @author chiraranw @ Date Jan 17, 2020
 *
 */
@SpringBootTest
public class StudentServiceTests {

	@Autowired
	StudentService studentService;

	@Tag("CRUD")
	@Nested
	@DisplayName("CRUD - testing")
	class CRUD {
		@Test
		@DisplayName("saving a new student object.")
		void testPersistingStudent() {
			assertTrue(studentService
					.save(new Student(null, "Nation", "Chirara", "Spring Boot"))
					.getId() != null);
		}

		@Test
		@DisplayName("fetching all students.")
		void testGettingAllStudents() {
			assertTrue(studentService.getAll().size() > 0);
		}

		@Test
		@DisplayName("get a student by ID")
		void testGetByID() {
			assertEquals(5l, studentService.getByID(5l).get().getId());
		}

	}

}
