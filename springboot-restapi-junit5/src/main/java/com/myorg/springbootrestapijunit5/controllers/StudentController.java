package com.myorg.springbootrestapijunit5.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myorg.springbootrestapijunit5.model.Student;
import com.myorg.springbootrestapijunit5.services.StudentService;

@RestController
@CrossOrigin
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/get/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable Long id) {
		return new ResponseEntity<Student>(studentService.getByID(id).get(), HttpStatus.OK);
	}

	@GetMapping("/get/all")
	public ResponseEntity<List<Student>> getAll() {
		return new ResponseEntity<List<Student>>(studentService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/st")
	public Student getStudentAsJson(@RequestParam(value = "id",defaultValue = "6",required = true) Long id) {
		return studentService.getByID(id).get();
	}
	
	@PostMapping("/create")
	public ResponseEntity<Student> create(@RequestBody Student student){
		return new ResponseEntity<Student>(studentService.save(student),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id", required = true)Long id){
		studentService.delete(id);
		return new ResponseEntity<String>("Deleted student with id: "+id,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Student student){
		return new ResponseEntity<>(studentService.update(
				student.getName(),
				student.getSurname(),
				student.getCourse(),
				student.getId()
				),HttpStatus.CREATED);
	}
	
	@PatchMapping("/update/course")
	public ResponseEntity<?> changeCourse(
			@RequestParam(name="course", required = true,defaultValue = "test")String course,
			@RequestParam(name="id",required = true,defaultValue = "9") Long id){
		return new ResponseEntity<>(studentService.changeCourse(course, id),HttpStatus.CREATED);
	}

}
