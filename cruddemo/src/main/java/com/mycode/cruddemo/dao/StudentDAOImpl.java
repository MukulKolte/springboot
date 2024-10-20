package com.mycode.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycode.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	//define field for entity manager
	private EntityManager entityManager;
	
	//inject entity manager using constructor injection
	
	@Autowired
	public StudentDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	//implement save method
	@Override
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
	}

	//implement read method
	
	@Override
	public Student findById(Integer ID) {

		return entityManager.find(Student.class, ID);
	}


	//Implement retrieval through query
	@Override
	public List<Student> findAll() {

		//create query
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student ORDER BY lastName", Student.class);
		
		//return query results
		
		return theQuery.getResultList();
	}


	@Override
	public List<Student> findByLastname(String lastname) {
		
		//create query
		TypedQuery<Student> lastnameQuery = entityManager.createQuery("FROM Student WHERE lastName = :theData", Student.class);
		
		//set Query response
		lastnameQuery.setParameter("theData", lastname);
		
		//return the result
		return lastnameQuery.getResultList();
	}


	@Override
	@Transactional
	public void updateStudent(Student theStudent) {
		
		entityManager.merge(theStudent);
		
	}


	@Override
	@Transactional
	public void updateWithQuery() {
		
		int updatedRwos = entityManager.createQuery("UPDATE Student SET lastName='Test' WHERE lastName='Doe'").executeUpdate();
	}


	@Override
	@Transactional
	public void deleteStudent(int id) {
		
		Student studentToDelete = entityManager.find(Student.class, id);
		
		entityManager.remove(studentToDelete);
	}


	@Override
	@Transactional
	public void deleteAll() {
		
		entityManager.createQuery("DELETE FROM Student").executeUpdate();
		
	}

	
}
