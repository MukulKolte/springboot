package com.mycode.advancedjpa.cruddemowithadvancedjpa.dao;

import com.mycode.advancedjpa.cruddemowithadvancedjpa.entity.Instructor;

public interface AppDAO {

	void save(Instructor theInstructor);
	Instructor findById(int id);
	void deleteInstructor(int theId);
}
