package com.mycode.advancedjpa.cruddemowithadvancedjpa.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycode.advancedjpa.cruddemowithadvancedjpa.entity.Instructor;
import com.mycode.advancedjpa.cruddemowithadvancedjpa.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AppDAOImpl implements AppDAO {

	//define field for entity manager
	
	private EntityManager entityManager;
	
	//inject EntityManager using constructor injection

	@Autowired
	public AppDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public void save(Instructor theInstructor) {
		entityManager.persist(theInstructor);
	}

	@Override
	public Instructor findById(int id) {
		
		return entityManager.find(Instructor.class, id);
	}

	@Override
	@Transactional
	public void deleteInstructor(int theId) {
		
		//retrieve instructor
		Instructor tempInstructor = entityManager.find(Instructor.class, theId);
		
		entityManager.remove(tempInstructor);
		
	}

	@Override
	public InstructorDetail findInstructorDetailById(int id) {
		
		return entityManager.find(InstructorDetail.class, id);
	}

	@Override
	@Transactional
	public void deleteInstructorDetailById(int id) {
		
		//get instructor detail by id
		InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, id);
		
		//remove the associated object reference
		//break the bi-directional link
		tempInstructorDetail.getInstructor().setInstructorDetail(null);
		
		//remove the entry which will cascade the removal to Instructor class as well.
		entityManager.remove(tempInstructorDetail);
		
	}
	
}
