package com.mycode.advancedjpa.cruddemowithadvancedjpa.dao;

import java.util.List;

import com.mycode.advancedjpa.cruddemowithadvancedjpa.entity.Course;
import com.mycode.advancedjpa.cruddemowithadvancedjpa.entity.Instructor;
import com.mycode.advancedjpa.cruddemowithadvancedjpa.entity.InstructorDetail;
import com.mycode.advancedjpa.cruddemowithadvancedjpa.entity.Student;

public interface AppDAO {

	void save(Instructor theInstructor);
	Instructor findById(int id);
	void deleteInstructor(int theId);
	
	InstructorDetail findInstructorDetailById(int id);
	void deleteInstructorDetailById(int id);
	
	List<Course> findCoursesByInstructorId(int theId);
	Instructor findInstructorByIdJoinFetch(int theId);
	
	void update(Instructor theInstructor);
	void update(Course theCourse);
	
	Course findCourseById(int theId);
	
	void deleteCourseById(int theId);
	
	void save(Course theCourse);
	Course findCourseAndReviewsByCourseId(int theId);
	
	Course findCourseAndStudentsByCourseId(int theId);
	Student findStudentAndCoursesByStudentId(int theId);
	
	void update(Student student);
	
	void deleteStudentById(int theId);
}
