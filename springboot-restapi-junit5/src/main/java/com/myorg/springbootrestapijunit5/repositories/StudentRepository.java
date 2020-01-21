/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myorg.springbootrestapijunit5.repositories;

import com.myorg.springbootrestapijunit5.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author chiraranw
 * @ Date    Jan 15, 2020
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	@Modifying
	@Query("UPDATE Student s SET s.name= :name,s.surname= :surname,s.course= :course WHERE  s.id= :id")
	public int update(
			@Param("name") String name,
			@Param("surname") String surname,
			@Param("course") String course,
			@Param("id") Long id
			);
	
	@Modifying
	@Query("UPDATE Student s SET s.course= :course WHERE  s.id= :id")
	public int changeCourse(
			@Param("course") String course,
			@Param("id") Long id
			);

}
