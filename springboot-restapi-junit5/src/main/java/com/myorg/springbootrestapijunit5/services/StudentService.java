/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.springbootrestapijunit5.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myorg.springbootrestapijunit5.model.Student;
import com.myorg.springbootrestapijunit5.repositories.StudentRepository;

/**
 *
 * @author chiraranw @ Date Jan 15, 2020
 *
 */
@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	
	@Transactional
	public Student save(Student student) {
		return studentRepository.save(student);
	}
	@Transactional
	public List<Student> getAll() {
		return this.studentRepository.findAll();
	}
	@Transactional
	public Optional<Student> getByID(Long id) {
		return this.studentRepository.findById(id);
	}
	@Transactional
	public void delete(Long id) {
		studentRepository.deleteById(id);
	}
	
	@Transactional
	public int update(String name, String surname,String course,Long id) {		
		return studentRepository.update(name,surname,course,id);
	}
	@Transactional
	public int changeCourse(String course,Long id) {		
		return studentRepository.changeCourse(course,id);
	}


}
