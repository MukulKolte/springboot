package com.mycode.advancedjpa.cruddemowithadvancedjpa.dao;

import com.mycode.advancedjpa.cruddemowithadvancedjpa.entity.Instructor;
import com.mycode.advancedjpa.cruddemowithadvancedjpa.entity.InstructorDetail;

public interface AppDAO {

	void save(Instructor theInstructor);
	Instructor findById(int id);
	void deleteInstructor(int theId);
	
	InstructorDetail findInstructorDetailById(int id);
	void deleteInstructorDetailById(int id);
}
